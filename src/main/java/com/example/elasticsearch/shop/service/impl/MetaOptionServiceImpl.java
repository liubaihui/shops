package com.example.elasticsearch.shop.service.impl;

import com.example.elasticsearch.shop.dto.ShopDto;
import com.example.elasticsearch.shop.entity.ShopEntity;
import com.example.elasticsearch.shop.service.MetaOptionService;
import com.example.elasticsearch.shop.service.ShopService;
import com.example.elasticsearch.shop.utils.BaseExceptin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.stereotype.Service;

/**
 * @Author : liubh
 * @Date: 2020-04-01 11:51
 */
@Service
public class MetaOptionServiceImpl implements MetaOptionService {
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Override
    public Boolean createIndex() {
        return elasticsearchTemplate.createIndex(ShopEntity.class);
    }

    @Override
    public Boolean createMapping() {
        //创建索引成功创建mapping
        Boolean index = this.createIndex();
        if (index) {
            boolean mapping = elasticsearchTemplate.putMapping(ShopEntity.class);
            if (mapping) {
                return true;
            } else {
                return false;
            }

        } else {
            // throw new BaseExceptin("1000","创建索引失败","create index fails");
            return false;
        }
    }
}
