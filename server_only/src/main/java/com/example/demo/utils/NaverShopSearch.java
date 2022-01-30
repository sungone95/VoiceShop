package com.example.demo.utils;

import com.example.demo.dto.ItemDto;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class NaverShopSearch {
    public String search(String query, String option) {                     //네이버 api 연동 form
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Naver-Client-Id", "9kXUWrIibgOTcsHKxVjV");
        headers.add("X-Naver-Client-Secret", "SWn1ELZDWB");
        String body = "";
        HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);

        ResponseEntity<String> responseEntity =
                rest.exchange("https://openapi.naver.com/v1/search/shop.json?query=" + query +"&display=27&start=1&sort="+option , HttpMethod.GET, requestEntity, String.class);

        String response = responseEntity.getBody();
        return response;
    }

    public List<ItemDto> fromJSONtoItems(String result) {           //네이버 api 검색목록에서 원하는 정보(items) 추출하는 작업
        JSONObject rjson = new JSONObject(result);
        JSONArray items = rjson.getJSONArray("items");
        List<ItemDto> ret = new ArrayList<>();

        for (int i=0; i<items.length(); i++) {
            JSONObject itemJson = items.getJSONObject(i);
            ItemDto itemDto = new ItemDto(itemJson);
            ret.add(itemDto);
        }
        return ret;
    }
}
