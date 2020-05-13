package com.example.webpack.controller;


import com.example.webpack.POJO.User;
import com.example.webpack.Util.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
/**
 * 测试接受json格式的数据,解析打印,并返回json数据
 */
public class JsonController {
    @PostMapping("/testJson")
    public AjaxResponse testJson(@RequestBody User user) {
        log.info(user.toString());
        User user1 = new User(0, "测试用户", "123", "10086", 2);
        return AjaxResponse.success(user1);
    }

}
