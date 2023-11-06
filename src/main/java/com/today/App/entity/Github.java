package com.today.App.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Github {
    private String id;
    private String login;
    private String avatarUrl;
    private String url;
    private String htmlUrl;
    private String type;
}
