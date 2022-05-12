package com.example.gameaggregator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class GamesLoader {
    public static List<Object> toList(JSONArray array) throws JSONException {
        List<Object> list = new ArrayList<Object>();
        for (int i = 0; i < array.length(); i++) {
            Object value = array.get(i);
            if (value instanceof JSONArray) {
                value = toList((JSONArray) value);
            } else if (value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }
            list.add(value);
        }
        return list;
    }
    public static Map<String, Object> toMap(JSONObject jsonObject)  throws JSONException {
        Map<String, Object> map = new HashMap<String, Object>();
        Iterator<String> keys = jsonObject.keys();
        while(keys.hasNext()) {
            String key = keys.next();
            Object value = jsonObject.get(key);
            if (value instanceof JSONArray) {
                value = toList((JSONArray) value);
            } else if (value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }
            map.put(key, value);
        }   return map;
    }
    static String read(InputStream inputStream) {
        String result = new BufferedReader(new InputStreamReader(inputStream))
                .lines().collect(Collectors.joining("\n"));
        return result;
    }
    static public void load(InputStream inputStream) {
        Data.GAMES.clear();
        try {
            String jsonString = read(inputStream);
            JSONArray arr = new JSONArray(jsonString);
            for (int i = 0; i < arr.length(); i++) {
                try {
                    JSONObject gameData = arr.getJSONObject(i);
                    String name = gameData.getString("NAME");
                    String url = gameData.getString("URL");
                    String desc = gameData.getString("DESC");
                    int id  = gameData.getInt("ID");
                    JSONObject categories = gameData.getJSONObject("CATEGORIES");
                    Category category = new Category(toMap(categories));
                    Game game = new Game(id, name, desc, url, category);
                    Data.GAMES.add(game);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        /**
        final DatabaseReference rootRef = Data.db.getReference();
        final String jsonString = new String;
        rootRef.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    jsonString = String.valueOf(task.getResult().getValue());
                }
            }
        });
         **/
    }
    public static void loadFavourite(InputStream inputStream) {
        Data.FAVOURITE_GAMES_IDS.clear();
        Data.FAVOURITE_GAMES.clear();
        try {
            String jsonString = read(inputStream);
            JSONArray jsonArray = new JSONArray(jsonString);
            List<Object> list = toList(jsonArray);
            list.forEach(x->Data.FAVOURITE_GAMES_IDS.add((Integer)x));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        for (Game game : Data.GAMES) {
            if (Data.FAVOURITE_GAMES_IDS.contains(game.getId())) {
                Data.FAVOURITE_GAMES.add(game);
            }
        }
    }
}
