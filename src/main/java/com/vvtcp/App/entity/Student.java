package com.vvtcp.App.entity;


import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Integer no;
    private String name;
    private String sex;
    private short age;
    private String email;
}
