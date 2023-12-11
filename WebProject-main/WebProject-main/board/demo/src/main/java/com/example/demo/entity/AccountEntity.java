package com.example.demo.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
public class AccountEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;
    @Column private String password;


    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Builder
    public AccountEntity(String username, String password){
        this.username = username;
        this.password = password;
    }
}
