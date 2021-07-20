package com.example.sprintbootdemo.entity;

import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class Emp {
    private Integer empno;
    private String ename;
    private String job;
    private Integer mgr;
    private Date hiredate;
    private double sal;
    private Float comm;
    private Integer deptno;
    private String dname;

    public Emp(Integer empno, String ename, String job, Integer mgr, String hiredate, double sal, Float comm, Integer deptno, String dname) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.mgr = mgr;
        try {
            this.hiredate = new SimpleDateFormat("yyyy-MM-dd").parse(hiredate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.sal = sal;
        this.comm = comm;
        this.deptno = deptno;
        this.dname = dname;
    }
}
