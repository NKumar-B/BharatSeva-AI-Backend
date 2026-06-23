package com.bharatseva.api.model;

public class Scheme {
    private String title;
    private String type;
    private String desc;
    private String url;

    public Scheme(String title, String type, String desc, String url) {
        this.title = title;
        this.type = type;
        this.desc = desc;
        this.url = url;
    }

    // Getters and Setters
    public String getTitle() { return title; }
    public String getType() { return type; }
    public String getDesc() { return desc; }
    public String getUrl() { return url; }
}