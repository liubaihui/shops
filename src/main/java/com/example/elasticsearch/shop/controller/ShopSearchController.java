package com.example.elasticsearch.shop.controller;

import com.example.elasticsearch.shop.dto.ShopDto;
import com.example.elasticsearch.shop.entity.ShopEntity;
import com.example.elasticsearch.shop.service.ShopService;
import com.example.elasticsearch.shop.utils.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "*", maxAge = 3600)
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

    /**
     * 搜索产品
     */
    @GetMapping()
    public ResponseVo<List<ShopEntity>> getShopSearch(@RequestParam("page") int page, @RequestParam("size") int size) {
        List<ShopEntity> shopEntities = shopService.queryShop(page, size);
        return new ResponseVo().success(shopEntities);
    }

    /**
     * 根据id搜索产品
     */
    @GetMapping("/shopId")
    public ResponseVo<ShopEntity> getShopById(@RequestParam("id") String id) {
        ShopEntity shopEntity = shopService.queryShopById(id);
        return new ResponseVo().success(shopEntity);
    }
}
