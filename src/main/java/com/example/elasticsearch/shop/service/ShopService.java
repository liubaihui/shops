package com.example.elasticsearch.shop.service;

import com.example.elasticsearch.shop.dto.ShopDto;
import com.example.elasticsearch.shop.entity.ShopEntity;

import java.util.List;

public interface ShopService {
    Boolean saveShop(ShopDto shopDto);
    List<ShopEntity> queryShop(int page, int size);
    ShopEntity queryShopById(String id);
}
