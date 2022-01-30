package com.example.demo.controller;

import com.example.demo.dto.BasketVO;
import com.example.demo.dto.CardVO;
import com.example.demo.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
public class CardController {

    @Autowired
    CardService cardService;

    @GetMapping("/card/checkcard")                                          //카드 등록 여부 체크
    int check(@RequestParam String userid){
        return cardService.cardcheck(userid);
    }

    @PostMapping("/card/pluscard")                                          //카드 등록하기 (여러개 등록가능)
    int plus(@RequestBody CardVO newcard){
        return cardService.cardregister(newcard);
    }

    @GetMapping("/card/showcard")                                           //해당 회원의 카드목록 반환
    List<BasketVO> show(@RequestParam String userid){
        return cardService.showcard(userid);
    }

    @GetMapping("/card/checkpwd")                                           //결제시 카드 비밀번호 확인작업
    int checkpwd(@RequestParam String userid, @RequestParam int index, @RequestParam char input, @RequestParam String cardcompany){
        String temppwd = cardService.getcardpwd(userid, cardcompany);
        if(temppwd == null)return -1;

        if(temppwd.charAt(index-1) == input)return 1;
        else return -1;
    }

    @GetMapping("/card/cleardb")                                            // 디비 정보 날리기
    int cleardb(@RequestParam int flag){
        return cardService.cleardb(flag);
    }
}
