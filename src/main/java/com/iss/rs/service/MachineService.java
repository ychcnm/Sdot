package com.iss.rs.service;

import com.iss.rs.entity.Machine;
import com.iss.rs.mapper.MachineMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "MacService")
public class MachineService {

    @Resource
    private MachineMapper machineMapper;

    public List<Machine> getAllMachine() {
        return machineMapper.getAllMachine();
    }
}
