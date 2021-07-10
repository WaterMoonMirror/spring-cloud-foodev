package com.tkn.hystrixfailback.controller;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import com.tkn.feignserverintf.service.IUserservice;
import com.tkn.feignserverintf.service.User;
import com.tkn.hystrixfailback.hystrix.MyService;
import lombok.Cleanup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    @Autowired
    RequestCacheService requestCacheService;

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

    /**
     * 多级降级
     *
     * @return
     */
    @Override
    public String chainerro() {
      return myService.chainerro();
    }

    @Override
    public User list(User user) {
        return myService.list(user);
    }

    @GetMapping("/cache")
    public User cache(String name) {
        @Cleanup HystrixRequestContext context =
                HystrixRequestContext.initializeContext();

        User friend = requestCacheService.list(name);
         friend = requestCacheService.list(name);
        friend = requestCacheService.list(name);
        return friend;
    }
}
