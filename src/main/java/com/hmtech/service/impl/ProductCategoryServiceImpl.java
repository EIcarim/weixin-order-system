package com.hmtech.service.impl;

import com.hmtech.dao.ProductCategoryDao;
import com.hmtech.domain.ProductCategory;
import com.hmtech.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Override
    public List<ProductCategory> findAll() {
        return productCategoryDao.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List categoryTypes) {
        return productCategoryDao.findByCategoryTypeIn(categoryTypes);
    }

    @Override
    public ProductCategory findOne(Integer categoryId) {
        return productCategoryDao.findOne(categoryId);
    }

    @Override
    public void save(ProductCategory productCategory) {
        productCategoryDao.save(productCategory);
    }

    @Override
    public void delete(Integer categoryId) {
        productCategoryDao.delete(categoryId);
    }
}
