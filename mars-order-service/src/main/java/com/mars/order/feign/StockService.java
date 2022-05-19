package com.mars.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: Mars
 * @Description: 库存服务层
 * @Date: 2022/05/19 11:49
 */
@FeignClient(value = "mars-stock-service")
public interface StockService {

	@GetMapping(value = "/stock/deduct/{productId}/{stockCount}")
	String deductStock(@PathVariable("productId") Long productId, @PathVariable("stockCount") Integer stockCount);
}
