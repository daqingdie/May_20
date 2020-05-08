package com.example.webpack.service.impl;

import com.example.webpack.Dao.User;
import com.example.webpack.Dao.UserRepository;
import com.example.webpack.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Slf4j
@Service
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
}
