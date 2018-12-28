package com.hmtech.enums;

import lombok.Getter;

/**
 * 商品状态信息
 */
@Getter
public enum ProductStatusEnum {

    up(1, "在架"),
    down(0, "下架");

    private Integer status;
    private String desc;

    ProductStatusEnum(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }
}
