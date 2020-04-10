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
    private ShopEmum shopEmum=ShopEmum.OWERN;
    /**
     * 商品价格
     */
    private Double shopprice;
    /**
     * 促销价格
     */
    private Double promotionpress;
    /**
     * 销量
     */
    private int salenumber;
    /**
     * 库存
     */
    private int stocknumber;
    /**
     * 主图
     */
    private String masterpicture;
    /**
     * 详情图片
     */
    private String detailpicture;
}
