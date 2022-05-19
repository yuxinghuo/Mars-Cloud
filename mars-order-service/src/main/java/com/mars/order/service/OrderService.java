package com.mars.order.service;

import com.mars.order.feign.CreditService;
import com.mars.order.feign.StockService;
import com.mars.order.feign.WmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Mars
 * @Description: 订单服务层
 * @Date: 2022/05/19 11:49
 */
@Service
public class OrderService {
	@Autowired
	private StockService stockService;
	@Autowired
	private CreditService creditService;
	@Autowired
	private WmsService wmsService;

	public String createOrder(Long productId, Long userId, Integer stockCount, Integer creditCount) {
		System.out.println("创建一条订单+1");
		stockService.deductStock(productId,stockCount);
		creditService.addCredit(userId,creditCount);
		wmsService.delivery(userId,productId);
		return "success";
	}
}
