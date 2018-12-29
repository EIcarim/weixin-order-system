package com.hmtech.dao;

import com.hmtech.domain.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * 商品信息dao层
 */
import java.util.List;


public interface ProductInfoDao extends JpaRepository<ProductInfo,String>,JpaSpecificationExecutor<ProductInfo> {

    List<ProductInfo> findByProductStatus (Integer productStatus);

}
