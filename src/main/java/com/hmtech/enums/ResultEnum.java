package com.hmtech.enums;

import lombok.Getter;

@Getter
public enum  ResultEnum {
    SUCCESS(0,"成功"),
    PARAM_ERROR(1,"参数错误"),
    PRODUCT_NOT_EXIST(10,"商品不存在"),
    PRODUCT_STOCK_ERROR(11,"商品库存错误"),
    ORDER_NOT_EXIST(12,"订单不存在"),
    ORDER_DETAIL_NOT_EXIST(13,"订单详情不存在"),
    ORDER_STATUS_ERROR(14,"订单状态错误"),
    ORDER_UPDATE_FAIL(15,"订单更新失败"),
    ORDER_DETAIL_EMPTY(16,"订单细节为空"),
    ORDER_PAY_STATUS_ERROR(17,"订单支付状态错误"),
    CART_EMPTY(18,"购物车为空"),
    ORDER_OWNER_ERROR(19,"订单不属于当前用户"),
    ORDER_CANCEL_SUCCESS(20,"订单取消成功"),
    ORDER_FINISH_SUCCESS(21,"订单完结成功"),
    PRODUCT_STATUS_ERROR(22,"商品状态错误"),
    PRODUCT_ONSALE_SUCCESS(23,"商品上架成功"),
    PRODUCT_OFFSALE_SUCCESS(24,"商品下架成功"),
    PRODUCT_SAVE_SUCCESS(25, "商品保存成功"),
    CATEGORY_SAVE_SUCCESS(26, "类别保存成功"),
    ;

    private Integer status;
    private String msg;

    ResultEnum(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }
}
