package com.tkn.hystrixfailback.controller;

import com.tkn.feignserverintf.service.IUserservice;
import com.tkn.hystrixfailback.hystrix.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lizhu@wondesgroup.com
 * @date: 2021/7/9 10:46
 * @description:
 */
@RestController
@RequestMapping("/fail")
public class FailBackController implements IUserservice {
    @Autowired
    MyService myService;

    @Override
    public String port() {
        return myService.port();
    }

    /**
     * 测试超时降级服务
     *
     * @param timeout
     * @return
     */
    @Override
    public String erro(Integer timeout) {
        return myService.erro(timeout);
    }
}
