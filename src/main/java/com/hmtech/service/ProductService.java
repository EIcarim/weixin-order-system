package com.hmtech.service;

import com.hmtech.domain.ProductInfo;
import com.hmtech.dto.CartDTO;
import com.hmtech.enums.ProductStatusEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 商品信息service层
 */
import java.util.List;

public interface ProductService {

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo findOne(String productId);

    List<ProductInfo> findUpAll();

    ProductInfo save(ProductInfo productInfo);

    void increaseStock(List<CartDTO> cartDTOList);

    void decreaseStock(List<CartDTO> cartDTOList);

    ProductInfo onSale(String productId);

    ProductInfo offSale(String productId);

}
