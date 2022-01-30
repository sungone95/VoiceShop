package com.example.demo.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Setter
@Getter
@Table(name="payment")
public class PaymentVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)         // 물품 여러개 결제할때 하나의 쿼리로 전체실행하기위한 설정
    @Column(name = "rownum")
    private int rownum;

    @Column(name = "customer")                                  // 회원id
    private String customer;

    @Column(name = "title")                                     // 결제 물품 이름
    private String title;

    @Column(name = "image")                                     // 결제 물품 이미지 파일
    private String image;

    @Column(name = "price")                                     // 결제 물품 가격
    private String price;

    @Column(name = "pid")                                       // 결제 물품 상품고유번호
    private String pid;

    @Column(name = "num")                                       // 결제 물품 갯수
    private String num;

    @Column(name = "buymonth")                                  // 결제날짜 몇월?
    private String buymonth;

    @Column(name = "buydate")                                   // 결제날짜 며칠??
    private String buydate;
}
