package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;
import org.json.JSONObject;

@Setter
@Getter
public class ItemDto {                              // api에서 얻어온 물품 정보
    private String title;
    private String link;
    private String image;
    private int lprice;
    private String hprice;
    private String mallName;
    private String productId;
    private String productType;
    private String maker;
    private String brand;
    private String category1;
    private String category2;
    private String category3;
    private String category4;

    public ItemDto(JSONObject itemJson) {
        this.title = itemJson.getString("title");
        this.link = itemJson.getString("link");
        this.image = itemJson.getString("image");
        this.lprice = itemJson.getInt("lprice");
        this.hprice = itemJson.getString("hprice");
        this.mallName = itemJson.getString("mallName");
        this.productId = itemJson.getString("productId");
        this.productType = itemJson.getString("productType");
        this.maker = itemJson.getString("maker");
        this.brand = itemJson.getString("brand");
        this.category1 = itemJson.getString("category1");
        this.category2 = itemJson.getString("category2");
        this.category3 = itemJson.getString("category3");
        this.category4 = itemJson.getString("category4");
    }
}
