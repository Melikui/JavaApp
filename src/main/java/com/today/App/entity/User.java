package com.today.App.entity;

import lombok.Data;

@Data
public class User {
    private int id;
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
