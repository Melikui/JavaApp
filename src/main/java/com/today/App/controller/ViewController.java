package com.today.App.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    @GetMapping(value = {"/", "/index", "/home"})
    public String html(Model model) {
        model.addAttribute("title", "· Life is long ,  you need Java . . .");
        model.addAttribute("content", "· Hello Java ~");
        return "index";
    }
}


