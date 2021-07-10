package com.tkn.hystrixfailback.hystrix;

import com.tkn.feignserverintf.service.IUserservice;
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
}
