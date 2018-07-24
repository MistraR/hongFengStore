package com.mistra.store.controller;

import com.mistra.store.entity.User;
import com.mistra.store.queryVo.GoodsVo;
import com.mistra.store.service.GoodsService;
import com.mistra.store.service.UserService;
import com.mistra.store.util.hibernate.PageCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Author: RoronoaZoro丶WangRui
 * Time: 2018/7/20/020
 * Describe: 用户   方法模块
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, User user, Model model) {
        if (userService.login(user)) {
            HttpSession session = request.getSession();
            session.setAttribute("isLogin", "Yes");
            PageCondition condition = new PageCondition();
            condition.setPageNum(0);
            condition.setPageSize(10);
            condition.setOrder("create_time");
            condition.setOrderBy("ASC");
            GoodsVo goodsVo = new GoodsVo();
            model.addAttribute("model", goodsService.pageSelect(condition, goodsVo));
            return "index";
        } else {
            request.setAttribute("error", "用户名或密码输入错误！");
            return "login";
        }

    }

}
