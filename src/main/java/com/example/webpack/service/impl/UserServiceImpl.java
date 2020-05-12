package com.example.webpack.service.impl;

import com.example.webpack.POJO.User;
import com.example.webpack.Dao.UserRepository;
import com.example.webpack.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@Transactional(rollbackOn = Exception.class)
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    public List<User> selectAll() {
        List<User> users = userRepository.findAll();
        return users;
    }

    /**
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public Page<User> findByPage(Integer page,Integer size) {
        PageRequest of = PageRequest.of(page, size);
        Page<User> pages = userRepository.findAll(of);
        return pages;
    }

    @Override
    public void insertUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(long Id) {
        userRepository.deleteById(Id);
    }

    @Override
    public void testTrans() throws RuntimeException{
        User user = selectAll().get(0);
        user.setPassword("123456");
        userRepository.save(user);
        int i = 2 / 0;
        user.setPhone("10086");
    }
}
