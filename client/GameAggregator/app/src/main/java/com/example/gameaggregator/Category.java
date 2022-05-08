package com.example.gameaggregator;

public class Category<T> {
    private CategoryType type;
    private T value;

    public Category(CategoryType type, T value) {
        this.type = type;
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public CategoryType getType() {
        return type;
    }

    public void setType(CategoryType type) {
        this.type = type;
    }
}
