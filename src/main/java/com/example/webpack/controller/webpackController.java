package com.example.webpack.controller;

import com.example.webpack.Dao.User;
import com.example.webpack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class webpackController {
    @Autowired
    private UserService userService;


    @RequestMapping("/testPage")
    public String toPage(Model model) {
        return "page";
    }

    @RequestMapping("/hello")
    public String index(Model model) {
        List<User> userList = userService.selectAll();
        System.out.println("哈哈");
        for (User user : userList) {
            System.out.println(user.getUsername());
        }
        return "hello";
    }

    @RequestMapping("/axios")
    public String axios() {
        return ("axios");
    }
}
