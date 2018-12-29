package com.hmtech.dao;

import com.hmtech.domain.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 商品分类dao层
 */

public interface ProductCategoryDao extends JpaRepository<ProductCategory,Integer>,JpaSpecificationExecutor<ProductCategory>{

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypes);

}
