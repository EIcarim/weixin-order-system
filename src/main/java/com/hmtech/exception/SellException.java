package com.hmtech.exception;

import com.hmtech.enums.ResultEnum;

public class SellException extends RuntimeException{

    private Integer status;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.status = resultEnum.getStatus();
    }

    public SellException(Integer status, String message) {
        super(message);
        this.status = status;
    }
}
