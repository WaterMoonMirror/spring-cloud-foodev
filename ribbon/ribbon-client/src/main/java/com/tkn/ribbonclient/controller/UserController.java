package com.tkn.ribbonclient.controller;

import com.tkn.ribbonclient.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author: lizhu@wondesgroup.com
 * @date: 2021/7/7 10:43
 * @description:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    public RestTemplate template;
    @GetMapping("/port")
    public String port(){
        return template.getForObject("http://ribbon-server/user/port",String.class);
    }
}
