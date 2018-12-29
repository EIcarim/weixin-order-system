package com.hmtech.domain;

import com.hmtech.enums.OrderStatusEnum;
import com.hmtech.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单主表
 */
@Entity
@Data
@Table(name = "order_master")
@DynamicUpdate
public class OrderMaster {

    @Id
    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    private BigDecimal orderAmount;

    private Integer orderStatus = OrderStatusEnum.NEW.getStatus();

    private Integer payStatus = PayStatusEnum.WAIT.getStatus();

    private Date createTime;

    private Date updateTime;
}
