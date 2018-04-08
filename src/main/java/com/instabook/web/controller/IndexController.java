package com.instabook.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping("/loggedIn")
    public String loggedIn() {
        return "loggedInTemp";
    }

    @RequestMapping("/signup")
    public String signup() {
        return "signup";
    }
}
