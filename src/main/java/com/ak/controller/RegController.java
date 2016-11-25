package com.ak.controller;

import com.ak.entity.User;
import com.ak.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * Created by MacDuck on 11/4/16.
 */
@Controller
@RequestMapping("/registration")
public class RegController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String registerForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @RequestMapping(method = RequestMethod.POST)
   public String registerUser(@ModelAttribute User user) {
        userService.addUser(user);
        User userWithoutRole = userService.findByLogin(user.getLogin());
        userService.setRole(userWithoutRole);
        return "done";
    }
}
