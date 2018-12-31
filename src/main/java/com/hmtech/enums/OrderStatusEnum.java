package com.hmtech.enums;

import lombok.Getter;

/**
 * 订单状态信息
 */
@Getter
public enum OrderStatusEnum implements StatusEnum {

    NEW(0,"新订单"),
    FINISHED(1, "完结"),
    CANCEL(2,"已取消")
    ;

    private Integer status;

    private String msg;

    OrderStatusEnum(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }
}
