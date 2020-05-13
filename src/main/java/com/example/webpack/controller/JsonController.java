package com.example.webpack.controller;


import com.example.webpack.POJO.JUser;
import com.example.webpack.POJO.User;
import com.example.webpack.Util.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Slf4j
@RestController
/**
 * 测试接受json格式的数据,解析打印,并返回json数据
 */
public class JsonController {
    @PostMapping("/testJson")
    public AjaxResponse testJson(@RequestBody User user) {
        log.info(user.toString());
        JUser user1 = new JUser(0L, "测试用户",new Date());
        return AjaxResponse.success(user1);
    }

}
