package com.dailyspringboot.practice.model;

public class Review {

    private Long id;
    private String title;
    private String content;
    private int star;

    public Review(){}
    public Review (Long id, String title, String content, int star) {
        setId(id);
        setTitle(title);
        setContent(content);
        setStar(star);
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getStar() {
        return star;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setStar(int star) {
        this.star = star;
    }
}
