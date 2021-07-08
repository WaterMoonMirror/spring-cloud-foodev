package com.tkn.feignclient.controller;

import com.tkn.feignserverintf.service.IUserservice;
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
}
