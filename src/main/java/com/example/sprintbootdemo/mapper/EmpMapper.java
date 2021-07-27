package com.example.sprintbootdemo.mapper;

import com.example.sprintbootdemo.entity.Emp;

import java.util.List;
import java.util.Map;

public interface EmpMapper {
    public Emp findById(Integer empno);
    //mybatis 使用map对象包含多个参数
    public List findDepts(Map param);
}
