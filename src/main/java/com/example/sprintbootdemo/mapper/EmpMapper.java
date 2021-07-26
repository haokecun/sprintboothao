package com.example.sprintbootdemo.mapper;

import com.example.sprintbootdemo.entity.Emp;

import java.util.List;

public interface EmpMapper {
    public Emp findById(Integer empno);
    public List findDepts();
}
