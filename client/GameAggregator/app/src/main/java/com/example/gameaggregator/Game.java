package com.example.gameaggregator;

public class Game {
    private String name;
    private String url;
    private String description;
    private Category category;
    private int id;
    public Game(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
    public Game(int id, String name, String description, String url) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.url = url;
    }
    public Game(int id, String name, String description, String url, Category categoryList) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.url = url;
        this.category = categoryList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategoryList() {
        return category;
    }

    public void setCategoryList(Category categoryList) {
        this.category = categoryList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
