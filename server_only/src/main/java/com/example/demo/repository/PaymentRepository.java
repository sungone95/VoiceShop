package com.example.demo.repository;

import com.example.demo.dto.PaymentVO;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentVO, String> {

    List<PaymentVO> findByCustomer(String customer);                                //회원id로 결제목록 모두 반환
    List<PaymentVO> findByCustomerAndBuymonth(String customer, String buymonth);    //회원id, 구매월로 결제목록 모두 반환
    List<PaymentVO> findByCustomerAndBuymonthAndBuydate(String customer, String buymonth, String buydate);  //회원id 구매월, 구매일로 결제목록 모두 반환
}
