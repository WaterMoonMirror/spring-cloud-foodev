package com.tkn.ribbonclient.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.tkn.ribbonclient.rules.Myrule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: lizhu@wondesgroup.com
 * @date: 2021/7/7 16:21
 * @description:
 */
@Configuration
public class RibbonConfigration {

    @Bean
    public IRule iRule(){
        // 随机
//        return new RandomRule();
        return new Myrule();
    }
}
