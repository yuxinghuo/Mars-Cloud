package com.mars.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: Mars
 * @Description: 信用服务层
 * @Date: 2022/05/19 11:49
 */
@FeignClient(value = "mars-credit-service",fallback = CreditServiceFallback.class)
public interface CreditService {

	@GetMapping(value = "/credit/addCredit/{userId}/{creditCount}")
	String addCredit(@PathVariable("userId") Long userId, @PathVariable("creditCount") Integer creditCount);
}
