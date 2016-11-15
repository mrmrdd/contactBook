package com.ak.controller;

import com.ak.entity.User;
import com.ak.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

/**
 * Created by MacDuck on 11/2/16.
 */
@Controller
public class HomeController {

    @Autowired
    UserService service;

    @RequestMapping("/")
    public String main(Model model) {
        model.addAttribute("name", "VULKAN");
        model.addAttribute("date", new Date());
        return "home";
    }

    @RequestMapping("/contact")
    public String contatcsList() {
        return "contacts";
    }
}
