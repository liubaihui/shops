package com.example.elasticsearch.shop.entity;

import com.example.elasticsearch.shop.enums.ShopEmum;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import java.io.Serializable;

/**
 * @Author : liubh
 * @Date: 2020-04-01 11:54
 */
@Data
@Document(indexName = "shop", type = "own")
public class ShopEntity implements Serializable {
    @Id
    @Field(type = FieldType.Keyword)
    private String id;
    @Field(type = FieldType.Text)
    private String name;
    @Field(type = FieldType.Text)
    private String address;
    @Field(type = FieldType.Keyword)
    private ShopEmum shopEmum;

}
