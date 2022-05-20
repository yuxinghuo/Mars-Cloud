package com.mars.order.feign;

import org.springframework.stereotype.Component;

/**
 * @Author: Mars
 * @Description: TODO
 * @Date: 2022/05/19 17:32
 */
@Component
public class CreditServiceFallback implements CreditService {

    @Override
    public String addCredit(Long userId, Integer creditCount) {
        System.out.println("调用积分服务失败，记录日志降级处理：userId="+userId+",creditCount="+creditCount);
        return "error";
    }
}
