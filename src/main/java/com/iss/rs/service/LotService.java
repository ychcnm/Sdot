package com.iss.rs.service;

import com.iss.rs.entity.Lot;
import com.iss.rs.mapper.LotMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "LotService")
public class LotService {

    @Resource
    private LotMapper lotMapper;

    public List<Lot> getAllLot() {
        return lotMapper.getAllLot();
    }

}
