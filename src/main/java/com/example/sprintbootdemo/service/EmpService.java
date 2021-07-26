package com.example.sprintbootdemo.service;

import com.example.sprintbootdemo.entity.Emp;
import com.example.sprintbootdemo.mapper.EmpMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EmpService {
    @Resource
    private EmpMapper empMapper = null;

    public Emp findById(Integer empno){
        return empMapper.findById(empno);
    }
}
