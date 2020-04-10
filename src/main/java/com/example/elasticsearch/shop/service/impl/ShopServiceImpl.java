package com.example.elasticsearch.shop.service.impl;

import com.example.elasticsearch.shop.dto.ShopDto;
import com.example.elasticsearch.shop.entity.ShopEntity;
import com.example.elasticsearch.shop.service.ShopService;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

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
        shopEntity.setCreateTime(new Date());
        shopEntity.setId(UUID.randomUUID().toString());
        IndexQuery indexQuery = new IndexQueryBuilder()
                .withObject(shopEntity).build();

        String index = elasticsearchTemplate.index(indexQuery);
        if (StringUtils.isNotBlank(index)) {
            return true;

        } else {
            return false;
        }

    }

    @Override
    public List<ShopEntity> queryShop(int page, int size) {
        QueryBuilder queryBuilder = new MatchAllQueryBuilder();

        SearchQuery searchQuery = new NativeSearchQuery(queryBuilder);
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Order.desc("createTime")));
        searchQuery.setPageable(pageable);
        AggregatedPage<ShopEntity> shopEntities = elasticsearchTemplate.queryForPage(searchQuery, ShopEntity.class);
        List<ShopEntity> content = shopEntities.getContent();
        return content;

    }

    @Override
    public ShopEntity queryShopById(String id) {
        GetQuery getQuery = new GetQuery();
        getQuery.setId(id);
        ShopEntity shopEntity = elasticsearchTemplate.queryForObject(getQuery, ShopEntity.class);
        if (shopEntity != null) {
            return shopEntity;
        }
        return null;
    }
}
