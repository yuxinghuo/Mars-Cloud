package com.mars.credit.controller;

import com.mars.credit.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author: Mars
 * @Description: 信用服务
 * @Date: 2022/05/19 11:49
 */
@RestController
@RequestMapping("/credit")
public class CreditController {

    @Autowired
    private CreditService creditService;
    @Autowired
    private Registration registration;

    @GetMapping(value = "/addCredit/{userId}/{creditCount}")
    public String addCredit(@PathVariable("userId") Long userId,
                            @PathVariable("creditCount") Integer creditCount) {
        return creditService.addCredit(userId, creditCount);
    }

    @GetMapping(value = "/getIpAndPort")
    public String getIpAndPort() {
        return registration.getHost() + ":" + registration.getPort();
    }
}
