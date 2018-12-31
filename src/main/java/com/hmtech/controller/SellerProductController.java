package com.hmtech.controller;

import com.hmtech.domain.ProductCategory;
import com.hmtech.domain.ProductInfo;
import com.hmtech.enums.ResultEnum;
import com.hmtech.exception.SellException;
import com.hmtech.form.ProductForm;
import com.hmtech.service.ProductCategoryService;
import com.hmtech.service.ProductService;
import com.hmtech.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/seller/product")
@Slf4j
public class SellerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "10") Integer size,
                             Map<String, Object> map) {

        PageRequest pageRequest = new PageRequest(page - 1, size);
        Page<ProductInfo> productInfoPage = productService.findAll(pageRequest);
        map.put("productInfoPage", productInfoPage);
        map.put("currentPage", page);
        map.put("size", size);
        return new ModelAndView("/product/list", map);
    }

    @GetMapping("/index")
    public ModelAndView update(@RequestParam(value = "productId", required = false) String productId,
                               Map<String, Object> map) {

        if (!StringUtils.isEmpty(productId)) {
            ProductInfo productInfo = productService.findOne(productId);
            map.put("productInfo", productInfo);
        }
        List<ProductCategory> productCategoryList = productCategoryService.findAll();
        map.put("productCategoryList", productCategoryList);
        return new ModelAndView("/product/index", map);
    }

    @GetMapping("/onSale")
    public ModelAndView onSale(@RequestParam("productId") String productId,
                               Map<String, Object> map) {
        try {
            productService.onSale(productId);
        } catch (SellException e) {
            log.error("[上架商品] 发生异常{}", e);
            map.put("msg", e.getMessage());
            map.put("url", "/common/error");
            return new ModelAndView(("/common/success"), map);
        }
        map.put("msg", ResultEnum.PRODUCT_ONSALE_SUCCESS.getMsg());
        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("/common/success", map);
    }

    @GetMapping("/offSale")
    public ModelAndView offSale(@RequestParam("productId") String productId,
                                Map<String, Object> map) {
        try {
            productService.offSale(productId);
        } catch (SellException e) {
            log.error("[下架商品] 发生异常{}", e);
            map.put("msg", e.getMessage());
            map.put("url", "/common/error");
            return new ModelAndView("/common/success", map);
        }
        map.put("msg", ResultEnum.PRODUCT_OFFSALE_SUCCESS.getMsg());
        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("/common/success", map);
    }

    @PostMapping("/save")
    private ModelAndView save(@Valid ProductForm productForm,
                              BindingResult bindingResult,
                              Map<String,Object> map) {

        if (bindingResult.hasErrors()) {
            log.error("[保存商品] 参数异常,productForm={}",productForm);
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/sell/seller/product/index");
            return new ModelAndView("/common/error", map);
        }

        ProductInfo productInfo = new ProductInfo();
        try {
            if (StringUtils.isEmpty(productForm.getProductId())) {
                productForm.setProductId(KeyUtil.genUniqueKey());
            }else{
                productInfo = productService.findOne(productForm.getProductId());
            }
            BeanUtils.copyProperties(productForm,productInfo);
            productService.save(productInfo);
        } catch (SellException e) {
            log.error("[保存商品] 发生异常{}",e);
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/product/index");
            return new ModelAndView("/common/error", map);
        }

        map.put("msg", ResultEnum.PRODUCT_SAVE_SUCCESS.getMsg());
        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("/common/success",map);
    }
}
