package com.example.webpack.service;

import com.example.webpack.POJO.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService  {
    public List<User> selectAll();

    /**
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    Page<User> findByPage(Integer page, Integer size);

    public void insertUser(User user);

    void deleteUser(long Id);

    void testTrans();
}
