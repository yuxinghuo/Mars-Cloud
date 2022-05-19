package com.mars.stock.service;

import org.springframework.stereotype.Service;

/**
 * @Author: Mars
 * @Description: 库存服务层
 * @Date: 2022/05/19 11:49
 */
@Service
public class StockService  {

	public String deductStock(Long productId, Integer stockCount) {
		System.out.println("库存减1");
		return "success";
	}
}
