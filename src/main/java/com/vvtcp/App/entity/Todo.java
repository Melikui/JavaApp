package com.vvtcp.App.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Todo {
    private int id;
    private String title;
    private int selected;
    private String content;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
