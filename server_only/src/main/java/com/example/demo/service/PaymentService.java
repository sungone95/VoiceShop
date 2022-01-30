package com.example.demo.service;


import com.example.demo.dto.BasketVO;
import com.example.demo.dto.PaymentVO;
import com.example.demo.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public int pluspayment(List<PaymentVO> newitems){                   // 결제목록에 아이템 추가
            paymentRepository.saveAll(newitems);
            return 1;
        }

    public List<PaymentVO> showpayment(String customer){                 // 해당 회원의 결제목록 반환
        return paymentRepository.findByCustomer(customer);
    }

    public int cleardb(int flag){                                       //  db날리기
        if(flag == 1)paymentRepository.deleteAllInBatch();
        return 1;
    }

    public List<PaymentVO> showmonth(String customer, String buymonth) {            //결제목록 결제월로 정렬
        return paymentRepository.findByCustomerAndBuymonth(customer, buymonth);
    }

    public List<PaymentVO> showdate(String customer, String buymonth, String buydate){      //결제목록 결제월,일로 정렬
        return paymentRepository.findByCustomerAndBuymonthAndBuydate(customer, buymonth, buydate);
    }

}
