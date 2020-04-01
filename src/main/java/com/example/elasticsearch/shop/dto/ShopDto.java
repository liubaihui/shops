package com.example.elasticsearch.shop.dto;

import com.example.elasticsearch.shop.enums.ShopEmum;
import lombok.Data;

@Data
public class ShopDto {
    /**
     * 商品名称
     */
    private String name;
    /**
     * 商品地址
     */
    private String address;
    /**
     * 商品类型
     */
    private ShopEmum shopEmum;
}
