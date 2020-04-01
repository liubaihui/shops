package com.example.elasticsearch.shop.enums;

public enum ShopEmum {
    OWERN(1, "OWERN", "本平台"),
    JDSHOP(2, "JDSHOP", "京东平台"),
    TAOBAOSHOP(3, "TAOBAOSHOP", "淘宝平台");
    private int code;
    private String name;
    private String info;

    ShopEmum(int code, String name, String info) {
        this.code = code;
        this.name = name;
        this.info = info;
    }
}
