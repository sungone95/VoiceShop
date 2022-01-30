package com.example.demo.service;


import com.example.demo.dto.BasketVO;
import com.example.demo.repository.BasketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BasketService {
    private final BasketRepository basketRepository;

    public int plusitem(BasketVO newitem){                             // 장바구니에 아이템 추가

        BasketVO temp = new BasketVO();
        temp.setCustomer(newitem.getCustomer());
        temp.setTitle(newitem.getTitle());
        temp.setImage(newitem.getImage());
        temp.setPrice(newitem.getPrice());
        temp.setPid(newitem.getPid());
        temp.setRowid(newitem.getRowid());
        basketRepository.save(temp);
        return 1;
    }

    public List showbasket(String customer){                              // 해당 회원의 장바구니 목록 반환
        return basketRepository.findByCustomer(customer);
    }

    @Transactional
    public int deleteall(String customer) {                             //해당 회원 상품목록 모두 삭제
        if(basketRepository.existsByCustomer(customer)){
            basketRepository.deleteAllByCustomer(customer);
            return 1;
        }
        else return -1;
    }

    @Transactional
    public int deleteone(int rowid){                                    //해당 회원이 선택한 항목1개만 삭제
        if(basketRepository.existsByRowid(rowid)){
            basketRepository.deleteByRowid(rowid);
            return 1;
        }
        else return -1;
    }
}
