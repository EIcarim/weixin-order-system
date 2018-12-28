package com.hmtech.vo;

import lombok.Data;

/**
 * http请求最外层的对象
 * @param <T>
 */

@Data
public class ResultVO<T> {

    //状态码
    private Integer code;

    //描述信息
    private String msg;

    //具体内容
    private T data;
}
