package com.du.config.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
public class Employee {
    private Integer id;
    private String name;
    private String email;
    private Integer gender; // 0:female; 1:male
    private Department department;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone ="GMT+08")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm" )
    private Date birth;

    public Employee(Integer id, String name, String email, Integer gender, Department department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.department = department;
        //默认日期
        this.birth = new Date();
    }

    public Employee(Integer id, String name, String email, Integer gender, Department department, Date birth) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.department = department;
        this.birth = birth;
    }
}
