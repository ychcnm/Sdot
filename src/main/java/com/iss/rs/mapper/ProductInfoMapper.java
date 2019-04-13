package com.iss.rs.mapper;

import com.iss.rs.entity.Productinfo;

import java.util.List;

public interface ProductInfoMapper {
    List<Productinfo> getAllProduct();

    List<String> getProductType(String series);
}
