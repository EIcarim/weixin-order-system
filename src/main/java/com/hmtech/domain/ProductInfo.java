package com.hmtech.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hmtech.enums.ProductStatusEnum;
import com.hmtech.utils.EnumUtil;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品信息对象
 */
@Entity
@Data
@DynamicUpdate
@Table(name = "product_info")
public class ProductInfo {

    @Id
    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productStock;

    private String productDescription;

    private String productIcon;

    private Integer productStatus;

    private Integer categoryType;

    private Date createTime;

    private Date updateTime;

    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum() {
        return EnumUtil.getByStatus(productStatus,ProductStatusEnum.class);
    }

}
