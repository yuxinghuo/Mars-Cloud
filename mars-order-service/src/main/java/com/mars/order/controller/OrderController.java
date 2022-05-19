package com.mars.order.controller;

import com.mars.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 * @Author: Mars
 * @Description: 订单服务
 * @Date: 2022/05/19 11:49
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private Registration registration;

    @GetMapping(value = "/create")
    public String createOrder(@RequestParam("productId") Long productId,
                              @RequestParam("userId") Long userId,
                              @RequestParam("stockCount") Integer stockCount,
                              @RequestParam("creditCount") Integer creditCount){
        orderService.createOrder(productId,userId,stockCount,creditCount);
        return "success";
    }


    /**
     * 直接调用原生http接口
     * @param productId
     * @param stockCount
     * @return
     */
    @GetMapping(value = "/stock/deduct")
    public String deductStock(@RequestParam("productId") Long productId,
                              @RequestParam("stockCount") Integer stockCount){
        return this.restTemplate.getForObject("http://mars-stock-service/stock/deduct/"+productId+"/"+stockCount,String.class);
    }

    @GetMapping(value = "/getIpAndPort")
    public String getIpAndPort(){
        return registration.getHost()+":"+registration.getPort();
    }
}
