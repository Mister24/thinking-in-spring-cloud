/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.fayuan.chapter13.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登录等controller
 *
 * @author mr.24
 * @version Id: MainController, v 1.0 2019-04-23 16:02 Exp $$
 */
@Controller
public class MainController {
    @RequestMapping("/") // 重定向到localhost:8081/index
    public String root() {
        return "redirect:/index";
    }

    @RequestMapping("/index") // localhost:8081/index
    public String index() {
        return "index";
    }

    @RequestMapping("/user/index") // localhost:8081/user/index
    public String userIndex() {
        return "user/index";
    }

    @RequestMapping("/login") // localhost:8081/login
    public String login() {
        return "login";
    }

    @RequestMapping("/login-error") // localhost:8081/login-error
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

    @RequestMapping("/401") // localhost:8081/401
    public String accessDenied() {
        return "401";
    }

}
