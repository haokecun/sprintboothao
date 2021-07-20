package com.example.sprintbootdemo.entity;

import lombok.Data;

@Data
public class Dept {
    private Integer deptno;
    private String dname;
    private String loc;

    public Dept(Integer deptno, String dname, String loc) {
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
    }

}
