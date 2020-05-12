package com.example.webpack;

import com.example.webpack.POJO.User;
import com.example.webpack.Dao.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.webpack.Dao.UserPageRepository;
import com.example.webpack.POJO.User;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JPATest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserPageRepository userPageRepository;

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

    @Test
    /**
     * 利用继承PagingAndSoringRepository的接口来测试JPA分页查询
     */
    public void testPage() {
        findAll(0, 5);
        System.out.println("---------------------------------------------");
        findAll(1, 5);
        System.out.println("---------------------------------------------");
        findAll(0,7);
    }

    private void findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<User> pUsers = userPageRepository.findAll(pageable);
        List<User> users = pUsers.getContent();
        System.out.println("全部记录为:"+pUsers.getTotalElements()+"条");
        System.out.println("全部页数为"+pUsers.getTotalPages()+"页");
        System.out.println("当前页码:第"+(pUsers.getNumber()+1)+"页");
        users.stream().forEach(u-> System.out.println(u));
    }
}
