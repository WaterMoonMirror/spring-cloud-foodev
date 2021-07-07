package com.tkn.ribbonserver.controller;

import com.tkn.ribbonserver.entity.User;
import com.tkn.ribbonserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: lizhu@wondesgroup.com
 * @date: 2021/7/7 09:56
 * @description:
 */
@RestController
@RequestMapping("/user")
public class UerController {

    @Autowired
    private ServletWebServerApplicationContext webServerAppCtxt;
    @Value("${server.port}")
    public String port;
    @Autowired
    public UserRepository repository;

    @GetMapping("/save")
     public User save(User user){
        return repository.save(user);
     }
    @GetMapping("/list")
    public List<User> save(){
        return repository.findAll();
    }
    @GetMapping("/port")
    public String port(){

        return String.valueOf(webServerAppCtxt.getWebServer().getPort()) ;
    }

}
