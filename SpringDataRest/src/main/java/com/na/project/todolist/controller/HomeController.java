package com.na.project.todolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "home";
    }

}