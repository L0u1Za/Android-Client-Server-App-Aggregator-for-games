package com.example.gameaggregator;

import java.util.HashMap;
import java.util.Map;

public class Category {
    private Map<String, Object> categoryMap;
    public Category(Map<String, Object> categoryMap) {
        this.categoryMap = categoryMap;
    }

    public Map<String, Object> getCategoryMap() {
        return categoryMap;
    }

    public void setCategoryMap(Map<String, Object> categoryMap) {
        this.categoryMap = categoryMap;
    }
    /**
    EVENT,
    AGE,
    GAME_TYPE {
     ONLINE,
     Offline
     }
    PERSONS_COUNT,
    DIFFICULTY,
    TIME
     **/
}
