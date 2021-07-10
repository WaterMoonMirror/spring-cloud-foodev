package com.tkn.hystrixfailback.hystrix;

import com.tkn.feignserverintf.service.IUserservice;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author: lizhu@wondesgroup.com
 * @date: 2021/7/9 11:07
 * @description:
 */
@FeignClient(value = "feign-server",fallback = UserFallback.class)
public interface MyService extends IUserservice {
}
