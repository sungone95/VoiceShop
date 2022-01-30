package com.example.demo.repository;

import com.example.demo.dto.BasketVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasketRepository extends JpaRepository<BasketVO, String> {

    List<BasketVO> findByCustomer(String customer);         //db에서 회원이름으로 장바구니 목록 모두 반환
    int deleteAllByCustomer(String customer);               //db에서 회원이름으로 장바구니 목록 모두 삭제
    int deleteByRowid(int rowid);                           //db에서 키값 rowid로 장바구니 목록 1개 삭제
    boolean existsByCustomer(String customer);              //db에서 회원id로 존재여부 파악
    boolean existsByRowid(int rowid);                       //db에서 rowid로 존재여부 파악

}
