package com.mars.wms.controller;

import com.mars.wms.service.WmsService;
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
@RequestMapping("/wms")
public class WmsController {

    @Autowired
    private WmsService wmsService;
    @Autowired
    private Registration registration;

    @GetMapping(value = "/delivery/{userId}/{productId}")
    public String delivery(@PathVariable("userId") Long userId,
                           @PathVariable("productId") Long productId) {
        return wmsService.delivery(userId, productId);
    }

    @GetMapping(value = "/getIpAndPort")
    public String getIpAndPort() {
        return registration.getHost() + ":" + registration.getPort();
    }
}
