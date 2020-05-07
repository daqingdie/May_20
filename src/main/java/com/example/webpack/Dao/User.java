package com.example.webpack.Dao;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="user")
@ToString
public class User {
    @Id
    @GeneratedValue
    private int id;

    @Column(length = 20)
    private String username;

    @Column(length = 20)
    private String password;

    @Column(length = 20)
    private String phone;

    @Column(nullable = false,length = 20)
    private int power;


}
