package com.du.config.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
public class Employee {
    private Integer id;
    private String name;
    private String email;
    private Integer gender; // 0:female; 1:male
    private Department department;
    private Date birth;


    public Employee(Integer id, String name, String email, Integer gender, Department department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.department = department;
        this.birth = birth;
        //默认日期
        this.birth = new Date();
    }
}
