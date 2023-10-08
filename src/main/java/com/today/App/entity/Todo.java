package com.today.App.entity;

import lombok.Data;

@Data
public class Todo {
    private int id;
    private String title;
    private int selected;
    private String content;
    private String create_time;
    private String update_time;
}
