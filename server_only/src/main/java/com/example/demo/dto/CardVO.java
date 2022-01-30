package com.example.demo.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@Entity
@Setter
@Getter
@Table(name="card")
public class CardVO {

    @Id
    @Column(name = "rowid")                         //key값, db에서 auto increment 설정
    private int rowid;

    @Column(name = "userid")                        //회원 id
    private String userid;

    @Column(name = "cardcompany")                   //카드사 이름
    private String cardcompany;

    @Column(name = "card_num")                      //카드 번호 12자리
    private String card_num;

    @Column(name = "pwd")                           //카드 비밀번호
    private String pwd;
}
