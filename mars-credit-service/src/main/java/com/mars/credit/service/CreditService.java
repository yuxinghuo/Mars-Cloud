package com.mars.credit.service;

import org.springframework.stereotype.Service;

/**
 * @Author: Mars
 * @Description: 信用服务层
 * @Date: 2022/05/19 11:49
 */
@Service
public class CreditService {

	public String addCredit(Long userId, Integer creditCount) {
		System.out.println("增加信用分+1");
		return "success";
	}
}
