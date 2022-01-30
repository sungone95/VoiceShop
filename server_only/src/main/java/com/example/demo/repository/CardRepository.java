package com.example.demo.repository;

import com.example.demo.dto.CardVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<CardVO, String> {

    List<CardVO> findByUserid(String userid);                                   //회원id로 카드 목록 모두 반환
    CardVO findCardVOByUseridAndCardcompany(String userid, String cardcompany); //회원id, 카드사로 해당 카드 반환
    boolean existsByUseridAndCardcompany(String userid, String cardcompany);    //회원id, 카드사로 해당 카드 존재여부 파악
    boolean existsByUserid(String userid);                                      //회원id로 회원존재여부 파악
}
