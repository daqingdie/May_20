package com.example.webpack.service.impl;

import com.example.webpack.Dao.User;
import com.example.webpack.Dao.UserRepository;
import com.example.webpack.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
}
