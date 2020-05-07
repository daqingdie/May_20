package com.example.webpack.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    public List<User> findByUsername(String name);
    public List<User> findByUsernameLike(String name);
}
