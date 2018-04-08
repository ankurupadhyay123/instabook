package com.instabook.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    public static final String LOGIN_VIEW_NAME = "login";

    @RequestMapping("/login")
    public String login() {
        return LOGIN_VIEW_NAME;
    }
}
