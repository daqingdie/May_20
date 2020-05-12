package com.example.webpack;

import com.example.webpack.POJO.User;
import com.example.webpack.Dao.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JPATest {
    @Autowired
    private UserRepository userRepository;

    //获取日志记录器Logger，名字为本类类名
    private static Logger log = Logger.getLogger("com.lq.JpaTest");

    @Test
    public void myTest() {
        System.out.println("哈哈");
        List<User> users = userRepository.findAll();
//        for (User user : userList) {
//            System.out.println(user.getUsername());
//        }

//        User user = userRepository.findByUsername("求职者测试员").get(0);
//        System.out.println(user.getUsername()+user.getPhone());
//        List<User> users= userRepository.findByUsernameLike("%求职者%");
//        for (User user1 : users) {
//            log.log(Level.INFO,user.toString());
//        }
        List<User> collect = users.stream().filter(s->{
            if(s.getId()>10&&s.getId()<15)
                return true;
            return false;
        }).map(u->{
            u.setUsername("哈哈哈哈");
            return u;
        }).sorted().collect(Collectors.toList());

        for (User user1 : collect) {
            log.info(user1.toString());
        }



    }
}
