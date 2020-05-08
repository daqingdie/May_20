package com.example.webpack.controller;

import com.example.webpack.Dao.User;
import com.example.webpack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class JPAController {
    @Autowired
    private UserService userService;


    @GetMapping("/findByPage")
    public Page<User> findByPage(Integer page, Integer size){
        Page<User> students = userService.findByPage(page, size);
        return students;
    }

    @PostMapping("/addUser")
    public String addUser(@RequestBody User user){
        Logger.getLogger("myerr").log(Level.INFO,user.toString());
        userService.insertUser(user);
        return "ok";
    }

    @DeleteMapping("/delUser")
    public String delUser(long id){
        Logger.getLogger("myerr").log(Level.INFO,String.valueOf(id));
        userService.deleteUser(id);
        return "ok";
    }


}
