package com.hmtech.service.impl;

import com.hmtech.dto.OrderDTO;
import com.hmtech.enums.ResultEnum;
import com.hmtech.exception.SellException;
import com.hmtech.service.BuyerService;
import com.hmtech.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private OrderService orderService;

    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {
        return checkOrderOwner(openid, orderId);

    }

    @Override
    public OrderDTO cancelOrder(String openid, String orderId) {
        OrderDTO orderDTO = checkOrderOwner(openid, orderId);
        if (orderDTO == null) {
            log.error("[取消订单]订单不存在,orderId={},openId={}", orderId, openid);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        OrderDTO cancelResult = orderService.cancel(orderDTO);
        if (cancelResult == null) {
            log.error("[取消订单],取消失败,orderId={},openId={}", orderId, openid);
            throw new SellException(ResultEnum.ORDER_UPDATE_FAIL);
        }
        return cancelResult;
    }

    private OrderDTO checkOrderOwner(String openid, String orderId) {
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null) {
            return null;
        }
        if (!openid.equals(orderDTO.getBuyerOpenid())) {
            log.error("[订单查询] openid不一致,openid={},orderDTO={}", openid, orderDTO);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDTO;
    }

}
