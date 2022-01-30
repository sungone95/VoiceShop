package com.example.demo.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@Entity
@Setter
@Getter
@Table(name="user")
public class UserVO {
    @Id
    @Column(name = "id", nullable = false)              //회원 id, 이자체로 key 값이므로 null금지
    private String id;

    @Column(name="pwd")                                 //회원 비밀번호
    private String pwd;

    @Column(name="name")                                //회원 이름
    private String name;

    @Column(name="address")                             //회원 주소
    private String address;
}
