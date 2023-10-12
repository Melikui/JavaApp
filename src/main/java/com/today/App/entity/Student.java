package com.today.App.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Integer no;
    private String name;
    private String sex;
    private short age;
    private String email;
}
