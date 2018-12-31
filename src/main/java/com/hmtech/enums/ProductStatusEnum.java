package com.hmtech.enums;

import lombok.Getter;

/**
 * 商品状态信息
 */
@Getter
public enum ProductStatusEnum implements StatusEnum{

    UP(0, "在架"),
    DOWN(1, "下架");

    private Integer status;
    private String msg;

    ProductStatusEnum(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }
}
