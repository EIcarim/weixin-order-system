package com.hmtech.service;

import com.hmtech.domain.ProductCategory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品信息service层
 */

public interface ProductCategoryService {

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List categoryTypes);

    ProductCategory findOne(Integer categoryId);

    void save(ProductCategory productCategory);

    void delete(Integer categoryId);


}
