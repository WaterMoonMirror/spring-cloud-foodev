package com.tkn.feignserverintf.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author: lizhu@wondesgroup.com
 * @date: 2021/7/8 15:47
 * @description:
 */
@FeignClient("feign-server")
public interface IUserservice {
    @GetMapping("/port")
     String port();

    /**
     *  测试超时降级服务
     * @param timeout
     * @return
     */
    @GetMapping("/erro")
     String erro(@RequestParam(name = "timeout") Integer timeout);

    /**
     *  多级降级
     * @return
     */
    @GetMapping("/chainerro")
    String chainerro();

    @PostMapping("/list")
    User list(@RequestBody  User user);

}
