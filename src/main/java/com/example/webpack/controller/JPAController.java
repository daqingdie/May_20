package com.example.webpack.controller;

import com.example.webpack.Dao.User;
import com.example.webpack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class JPAController {
    @Autowired
    private UserService userService;

    //获取日志记录器Logger，名字为本类类名
    private static Logger log = Logger.getLogger("com.lq.JPAController");


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

    @GetMapping("/axiosGetNews")
    public String axiosGetNews(String message){
        System.out.println(message);
        return "服务器发送的消息";
    }

    @PostMapping("/axiosPostNews")
    public String axiosPostNews(@RequestBody String message){
        System.out.println(message);
        return "服务器发送的消息";
    }

    @GetMapping("/testTrans")
    public String testTrans(Integer page, Integer size) {
        log.info(page.toString());
        try {
            userService.testTrans();
        }catch (Exception e)
        {
            e.printStackTrace();
            return e.toString();
        }
        return "点击成功";
    }


}
