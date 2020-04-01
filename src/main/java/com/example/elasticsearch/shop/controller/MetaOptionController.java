package com.example.elasticsearch.shop.controller;

import com.example.elasticsearch.shop.service.MetaOptionService;
import com.example.elasticsearch.shop.utils.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : liubh
 * @Date: 2020-04-01 12:23
 */
@RestController
@RequestMapping("/meta/option")
public class MetaOptionController {

    @Autowired
    private MetaOptionService metaOptionService;

    /**
     * 创建mapping
     */
    @PostMapping()
    public ResponseVo<Boolean> createMapping() {
        Boolean mapping = metaOptionService.createMapping();
        return new ResponseVo().success(mapping);
    }

}
