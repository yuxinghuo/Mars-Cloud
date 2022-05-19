package com.mars.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: Mars
 * @Description: 配送服务层
 * @Date: 2022/05/19 11:49
 */
@FeignClient(value = "mars-wms-service")
public interface WmsService {

	@GetMapping(value = "/wms/delivery/{userId}/{productId}")
	String delivery(@PathVariable("userId") Long userId, @PathVariable("productId") Long productId);
}
