package com.example.sprintbootdemo.controller;

import com.example.sprintbootdemo.entity.Emp;
import com.example.sprintbootdemo.service.EmpService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import java.util.List;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@Api(description = "员工接口")
@RestController
@RequestMapping("/emp/")
public class EmpController {

    @Resource
    private EmpService empService = null;

    @ApiOperation("获取员工信息")
    @GetMapping("/{id}")
    public Emp findById(@PathVariable("id") Integer id){
        Emp emp = empService.findById(id);
        return emp;
    }

    @ApiOperation("多条件获取员工信息")
    @GetMapping("/list")
    public List<Map> findDepts(String deptname,Float sal){
        List<Map> list = empService.findDepts(deptname,sal);
        return list;
    }

}
