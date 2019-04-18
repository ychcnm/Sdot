package com.iss.rs.service;

import com.iss.rs.entity.Oven;
import com.iss.rs.mapper.OvenMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "OvenService")
public class OvenService {

    @Resource
    private OvenMapper ovenMapper;

    public List<Oven> getAllOven() {
        return ovenMapper.getAllOven();
    }

}
