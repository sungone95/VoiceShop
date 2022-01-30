package com.example.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Setter
@Getter
@Table(name="basket")
public class BasketVO {

    @Id
    @Column(name = "rowid")                         //key값, db에서 auto increment 설정
    private int rowid;

    @Column(name = "customer")                      //회원 id
    private String customer;

    @Column(name = "title")                         //물품 이름
    private String title;

    @Column(name = "image")                         //물품 이미지 파일
    private String image;

    @Column(name = "price")                         //물품 가격
    private String price;

    @Column(name = "pid")                           //물품 pid
    private String pid;

}
