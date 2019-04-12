package com.iss.rs.service;

import com.iss.rs.entity.Productinfo;
import com.iss.rs.mapper.ProductInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "ProductService")
public class ProductService {

    @Resource
    private ProductInfoMapper productInfoMapper;

    public List<Productinfo> getAllProduct() {
        return productInfoMapper.getAllProduct();
    }
}
