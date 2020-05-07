package com.example.webpack;

import com.example.webpack.Dao.User;
import com.example.webpack.Dao.UserRepository;
import com.example.webpack.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JPATest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void myTest() {
        System.out.println("哈哈");
//        List<User> userList = userRepository.findAll();
//        for (User user : userList) {
//            System.out.println(user.getUsername());
//        }
        User user = userRepository.findByUsername("求职者测试员").get(0);
        System.out.println(user.getUsername()+user.getPhone());
        List<User> users= userRepository.findByUsernameLike("%求职者%");
        for (User user1 : users) {
            System.out.println(user1.toString());
        }
    }
}
