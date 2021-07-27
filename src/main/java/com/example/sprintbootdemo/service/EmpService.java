package com.example.sprintbootdemo.service;

import com.example.sprintbootdemo.entity.Emp;
import com.example.sprintbootdemo.mapper.EmpMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmpService {
    @Resource
    private EmpMapper empMapper = null;

    public Emp findById(Integer empno){
        return empMapper.findById(empno);
    }

    public List<Map> findDepts(String deptname, Float sal){
        Map param = new HashMap();
        param.put("deptno",deptname);
        param.put("sal",sal);
        return empMapper.findDepts(param);
    }
}
