package com.today.App.model;

public class Todo {
    private int id;
    private String title;
    private int selected;
    private String content;
    private String create_time;
    private String update_time;

    public Todo() {
    }

    public Todo(int id, String title, int selected, String content, String create_time, String update_time) {
        this.id = id;
        this.title = title;
        this.selected = selected;
        this.content = content;
        this.create_time = create_time;
        this.update_time = update_time;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSelected() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateTime() {
        return create_time;
    }

    public void setCreateTime(String create_time) {
        this.create_time = create_time;
    }

    public String getUpdateTime() {
        return update_time;
    }

    public void setUpdateTime(String update_time) {
        this.update_time = update_time;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", selected=" + selected +
                ", content='" + content + '\'' +
                ", create_time='" + create_time + '\'' +
                ", update_time='" + update_time + '\'' +
                '}';
    }
}
