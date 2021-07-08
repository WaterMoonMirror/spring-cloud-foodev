package com.tkn.feignserverintf.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: lizhu@wondesgroup.com
 * @date: 2021/7/8 15:47
 * @description:
 */
@FeignClient("feign-server")
public interface IUserservice {
    @GetMapping("/port")
     String port();
}
