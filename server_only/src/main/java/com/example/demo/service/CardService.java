package com.example.demo.service;


import com.example.demo.dto.CardVO;
import com.example.demo.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {
    private final CardRepository cardRepository;

    public int cardcheck(String userid){                                    //카드 존재여부 파악
        if(cardRepository.existsByUserid(userid))return 1;
        else return -1;
    }

    public int cardregister(CardVO cardVO){                                 //카드 등록하기
        cardRepository.save(cardVO);
        return 1;
    }

    public List showcard(String userid){
        return cardRepository.findByUserid(userid);
    }   //카드 목록 모두 반환

    public String getcardpwd(String userid, String cardcompany){                           //해당 카드 비번 반환
        if(cardRepository.existsByUseridAndCardcompany(userid, cardcompany)){
            CardVO tempcard = cardRepository.findCardVOByUseridAndCardcompany(userid, cardcompany);
            return tempcard.getPwd();
        }else return null;
    }

    public int cleardb(int flag){                           //db 날리기
        if(flag==1)cardRepository.deleteAllInBatch();
        return 1;
    }
}
