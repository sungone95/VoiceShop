package com.example.demo.controller;


import com.example.demo.dto.ItemDto;
import com.example.demo.utils.NaverShopSearch;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
public class SearchRequestController {
    private final NaverShopSearch naverShopSearch;

    @GetMapping("/api/item")                                        //네이버 쇼핑 api 이용하여 상품검색
    public List<ItemDto> getItems(@RequestParam String keyword, @RequestParam String option){
        String resultString = naverShopSearch.search(keyword, option);
        System.out.println(keyword);
        return naverShopSearch.fromJSONtoItems(resultString);
    }
}
