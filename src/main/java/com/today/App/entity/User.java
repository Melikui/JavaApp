package com.today.App.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    private int age;
    private String sex;
    private String position;
    private int salary;
    private int subsidy;
    private String mobile;
    private String email;
    private String address;
    private int isDelete;
}
