package com.hmtech.form;

import com.hmtech.enums.ProductStatusEnum;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class ProductForm {

    private String productId;

    @NotEmpty(message = "商品名必填")
    private String productName;

    @NotNull(message = "价格必填")
    private BigDecimal productPrice;

    @NotNull(message = "库存必填")
    private Integer productStock;

    @NotEmpty(message = "商品描述必填")
    private String productDescription;

    @NotEmpty(message = "图片必填")
    private String productIcon;

    private Integer productStatus = ProductStatusEnum.UP.getStatus();

    @NotNull(message = "商品类别必填")
    private Integer categoryType;
}
