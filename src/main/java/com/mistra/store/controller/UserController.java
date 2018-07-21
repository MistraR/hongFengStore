package com.mistra.store.controller;

import com.mistra.store.entity.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: RoronoaZoro丶WangRui
 * Time: 2018/7/20/020
 * Describe:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/login")
    public String login(User user){
        System.out.println(user.getUsername());
        return "index";
    }

}
