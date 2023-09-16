package com.today.App.model;

public class User {
    private int id;
    private String name;
    private String sex;
    private int age;
    private String position;
    private String mobile;

    public User() {
    }

    public User(int id, String name, String sex, int age, String position, String mobile) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.position = position;
        this.mobile = mobile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
