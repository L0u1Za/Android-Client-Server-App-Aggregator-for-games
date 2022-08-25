package com.example.gameaggregator;

import android.os.Parcel;
import android.os.Parcelable;

public class Game implements Parcelable {
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

    public Game(Parcel source) {
        name = source.readString();
        url = source.readString();
        description = source.readString();
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(url);
        dest.writeString(description);
    }

    public static final Creator<Game> CREATOR = new Creator<Game>() {
        @Override
        public Game[] newArray(int size) {
            return new Game[size];
        }

        @Override
        public Game createFromParcel(Parcel source) {
            return new Game(source);
        }
    };
}
