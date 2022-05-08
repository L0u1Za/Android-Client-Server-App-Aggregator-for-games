package com.example.gameaggregator;

import java.util.List;

public class Game {
    private String name;
    private String url;
    private String description;
    private List<Category> categoryList;
    private boolean isFavourite;
    public Game(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public Game(String name, String description, String url) {
        this.name = name;
        this.description = description;
        this.url = url;
    }
    public Game(String name, String description, String url, List<Category> categoryList) {
        this.name = name;
        this.description = description;
        this.url = url;
        this.categoryList = categoryList;
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

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public boolean getIsFavourite() {
        return isFavourite;
    }

    public void setIsFavourite(boolean favourite) {
        isFavourite = favourite;
    }
}
