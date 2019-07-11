package com.study.dubbo.controller;

import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author laidongxin
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @ResponseBody
    @RequestMapping(value = "/initOrder")
    public List<UserAddress> initOrder(@RequestParam("uid") String userId ) {
        return orderService.initOrder(userId);
    }
}
