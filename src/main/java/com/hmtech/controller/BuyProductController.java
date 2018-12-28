package com.hmtech.controller;

import com.hmtech.domain.ProductCategory;
import com.hmtech.domain.ProductInfo;
import com.hmtech.service.ProductCategoryService;
import com.hmtech.service.ProductInfoService;
import com.hmtech.utils.ResultVOUtil;
import com.hmtech.vo.ProductInfoVO;
import com.hmtech.vo.ProductVO;
import com.hmtech.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("buyer/product")
public class BuyProductController { 

    @Autowired
    private ProductCategoryService productCategoryService;

    @Autowired
    private ProductInfoService productInfoService;

    @GetMapping("/list")
    public ResultVO list(){

        //查询所有上架商品
        List<ProductInfo> productInfoList = productInfoService.findUpAll();

        //根据上架商品查询商品分类集合
        List<Integer> categrotyTypeList = productInfoList.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());

        //根据分类id查询category
        List<ProductCategory> productCategoryList = productCategoryService.findByCategoryTypeIn(categrotyTypeList);

        //数据拼接
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setFoods(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);

    }
}
