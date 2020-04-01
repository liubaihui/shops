package com.example.elasticsearch.shop.service.impl;

import com.example.elasticsearch.shop.dto.ShopDto;
import com.example.elasticsearch.shop.entity.ShopEntity;
import com.example.elasticsearch.shop.service.ShopService;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.stereotype.Service;

/**
 * @Author : liubh
 * @Date: 2020-04-01 11:51
 */
@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Boolean saveShop(ShopDto shopDto) {

        ShopEntity shopEntity = modelMapper.map(shopDto, ShopEntity.class);
        IndexQuery indexQuery = new IndexQueryBuilder()
        .withObject(shopEntity).build();

        String index = elasticsearchTemplate.index(indexQuery);
        if (StringUtils.isNotBlank(index)) {
            return true;

        } else {
            return false;
        }

    }
}
