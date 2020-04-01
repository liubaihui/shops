package com.example.elasticsearch.shop.controller;

import com.example.elasticsearch.shop.dto.ShopDto;
import com.example.elasticsearch.shop.service.ShopService;
import com.example.elasticsearch.shop.utils.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop")
public class ShopSearchController {

    @Autowired
    private ShopService shopService;

    /**
     * 创建商品
     *
     * @param shopDto
     */
    @PostMapping
    public ResponseVo<Boolean> saveShop(@RequestBody ShopDto shopDto) {
        Boolean result = shopService.saveShop(shopDto);
        if (result) {
            return new ResponseVo<>().success(result);
        } else {
            return new ResponseVo<>().fail(result);
        }


    }

    public void getShopSearch() {

    }
}
