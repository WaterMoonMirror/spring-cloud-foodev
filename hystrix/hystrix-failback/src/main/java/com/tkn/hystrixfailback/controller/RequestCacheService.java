package com.tkn.hystrixfailback.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.tkn.feignserverintf.service.User;
import com.tkn.hystrixfailback.hystrix.MyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: lizhu@wondesgroup.com
 * @date: 2021/7/10 23:53
 * @description:
 */
@Slf4j
@Service
public class RequestCacheService {
    @Autowired
    private MyService service;

    @CacheResult
    @HystrixCommand(commandKey = "cacheKey")
    public User list(@CacheKey String name){
        log.info("request cache " + name);
        User friend = new User();
        friend.setName(name);
        friend = service.list(friend);
        log.info("after requesting cache " + name);
        return friend;
    }

}
