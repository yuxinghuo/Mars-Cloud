package com.mars.wms.service;

import org.springframework.stereotype.Service;

/**
 * @Author: Mars
 * @Description: 库存服务层
 * @Date: 2022/05/19 11:49
 */
@Service
public class WmsService {

	public String delivery(Long userId, Long productId) {
		System.out.println("发货+1");
		return "success";
	}
}
