package com.tkn.feignclient.controller;

import com.tkn.feignserverintf.service.IUserservice;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lizhu@wondesgroup.com
 * @date: 2021/7/8 16:50
 * @description:
 */
@RestController
@RequestMapping("/user")
public class UserController implements IUserservice {
    @Autowired
    IUserservice iUserservice;
    @Override
    public String port() {
        return iUserservice.port();
    }

    /**
     * 测试超时降级服务
     *
     * @param timeout
     * @return
     */
    @SneakyThrows
    @Override
    public String erro(Integer timeout) {
        while (timeout-- >=0){
            Thread.sleep(1000);
        }
        return iUserservice.port();
    }

    /**
     * 多级降级
     *
     * @return
     */
    @Override
    public String chainerro() {
        return null;
    }
}
