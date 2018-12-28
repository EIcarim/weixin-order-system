package com.hmtech.service;

import com.hmtech.domain.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 商品信息service层
 */
import java.util.List;

public interface ProductInfoService {

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo findOne(String productId);

    List<ProductInfo> findUpAll();

    void save(ProductInfo productInfo);


}
