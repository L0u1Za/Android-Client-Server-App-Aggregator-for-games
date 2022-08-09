package com.example.gameaggregator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Category {
    private Map<String, Object> categoryMap;
    public Category() {
        this.categoryMap = new HashMap<String, Object> (){
            {
                put("EVENT", new ArrayList<String>());
                put("AGE", new ArrayList<Integer>());
                put("GAME_TYPE", new HashMap<String, Object> (){
                    {
                        put("ONLINE", new ArrayList<String>());
                        put("OFFLINE", new ArrayList<String>());
                    }
                });
                put("PERSONS_COUNT", new ArrayList<String>());
                put("DIFFICULTY", new ArrayList<String>());
                put("TIME", new ArrayList<String>());
            }
        };
    }
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
