package com.example.webpack.Dao;

import com.example.webpack.POJO.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface UserPageRepository extends PagingAndSortingRepository<User,Long> {


    Page<User> findAll(Pageable pageable);

    //Page<User> findByUsernameLike(String userName,Pageable pageable);

}
