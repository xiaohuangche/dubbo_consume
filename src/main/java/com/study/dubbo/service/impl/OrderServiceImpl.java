package com.study.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.service.OrderService;
import com.atguigu.gmall.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @Reference(url = "127.0.0.1:20882") dubbo直连
 * @author laidongxin
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Reference
    UserService userService;

    @HystrixCommand(fallbackMethod = "doException")
    @Override
    public List<UserAddress> initOrder(String userId) {

        //1、查询用户的收货地址
        List<UserAddress> addressList = userService.getUserAddressList(userId);
        return addressList;
    }


    public List<UserAddress> doException(String userId) {
        return Arrays.asList(new UserAddress(10, "测试地址", "1", "测试", "测试", "Y"));
    }
}
