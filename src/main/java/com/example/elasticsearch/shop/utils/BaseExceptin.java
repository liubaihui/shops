package com.example.elasticsearch.shop.utils;

import lombok.Data;

/**
 * @Author : liubh
 * @Date: 2020-04-01 12:42
 */
@Data
public class BaseExceptin extends Exception {
    private String code;
    private String message;
    private String info;

    public BaseExceptin(String code, String message, String info) {
        this.code = code;
        this.message = message;
        this.info = info;
    }

    public BaseExceptin(Throwable caser) {

    }

    public BaseExceptin(Throwable cause, String code, String message, String info) {
        super(cause);
        this.code = code;
        this.message = message;
        this.info = info;
    }
}
