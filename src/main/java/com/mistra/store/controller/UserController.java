package com.mistra.store.controller;

import com.mistra.store.entity.User;
import com.mistra.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Author: RoronoaZoro丶WangRui
 * Time: 2018/7/20/020
 * Describe:
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, User user) {
        if (userService.login(user)) {
            return "index";
        } else {
            request.setAttribute("error", "用户名或密码输入错误！");
            return "login";
        }

    }

}
