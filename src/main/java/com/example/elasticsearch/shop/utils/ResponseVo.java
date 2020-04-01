package com.example.elasticsearch.shop.utils;

import lombok.Data;

/**
 * @Author : liubh
 * @Date: 2020-04-01 13:03
 */
@Data
public class ResponseVo<T> {
    private int code;
    private String msg;
    private T data;

    public ResponseVo(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResponseVo() {
    }

    public ResponseVo success(T data){
        return new ResponseVo(200,"成功",data);
    }

    public ResponseVo fail(T data){
        return new ResponseVo(500,"失败",data);
    }
}
