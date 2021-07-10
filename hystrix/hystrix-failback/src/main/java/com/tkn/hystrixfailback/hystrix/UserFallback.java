package com.tkn.hystrixfailback.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.tkn.feignserverintf.service.IUserservice;
import com.tkn.feignserverintf.service.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author: lizhu@wondesgroup.com
 * @date: 2021/7/9 11:00
 * @description:
 */
@Slf4j
@Component
public class UserFallback  implements MyService {
    @Override
    public String port() {
        return null;
    }

    /**
     * 测试超时降级服务
     *
     * @param timeout
     * @return
     */
    @Override
    public String erro(Integer timeout) {
        return "this‘s is fallback!";
    }

    /**
     * 多级降级
     *
     * @return
     */
    @Override
    @HystrixCommand(fallbackMethod = "fallback2")
    public String chainerro() {
        log.info("Fallback: I'm not a black sheep any more");
        throw new RuntimeException("first fallback");
    }

    @Override
    public User list(User user) {
        return null;
    }

    @HystrixCommand(fallbackMethod = "fallback3")
    public String fallback2() {
        log.info("fallback again");
        throw new RuntimeException("fallback again");
    }

    public String fallback3() {
        log.info("fallback again and again");
        return "success";
    }
}
