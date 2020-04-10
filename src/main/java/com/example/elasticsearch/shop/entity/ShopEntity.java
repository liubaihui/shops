package com.example.elasticsearch.shop.entity;

import com.example.elasticsearch.shop.enums.ShopEmum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import java.io.Serializable;
import java.util.Date;

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

    /**
     * 商品价格
     */
    @Field(type = FieldType.Double)
    private Double shopprice;
    /**
     * 促销价格
     */
    @Field(type = FieldType.Double)
    private Double promotionpress;
    /**
     * 售价
     */
    @Field(type = FieldType.Long)
    private int salenumber;
    /**
     * 库存
     */
    @Field(type = FieldType.Long)
    private int stocknumber;
    /**
     * 主图
     */
    @Field(type = FieldType.Text)
    private String masterpicture;
    /**
     * 详情图片
     */
    @Field(type = FieldType.Text)
    private String detailpicture;

    @Field( type = FieldType.Date, format = DateFormat.custom,pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat (shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

}
