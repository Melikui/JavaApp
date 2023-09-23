package com.today.App.model;

public class Todo {
    private int id;
    private String value;
    private int selected;
    private String brief;
    private String create_time;

    public Todo() {
    }

    public Todo(int id, String value, int selected, String brief) {
        this.id = id;
        this.value = value;
        this.selected = selected;
        this.brief = brief;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getSelected() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getCreateTime() {
        return create_time;
    }

    public void setCreateTime(String create_time) {
        this.create_time = create_time;
    }
}
