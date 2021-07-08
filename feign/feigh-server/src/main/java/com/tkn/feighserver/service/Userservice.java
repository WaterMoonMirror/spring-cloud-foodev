package com.tkn.feighserver.service;

import com.tkn.feignserverintf.service.IUserservice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lizhu@wondesgroup.com
 * @date: 2021/7/8 15:58
 * @description:
 */
@RestController
@Slf4j
public class Userservice implements IUserservice {
    @Autowired
    private ServletWebServerApplicationContext webServerAppCtxt;
    @Override
    public String port() {
        return String.valueOf(webServerAppCtxt.getWebServer().getPort()) ;
    }
}
