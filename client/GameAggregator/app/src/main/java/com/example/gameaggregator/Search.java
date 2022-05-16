package com.example.gameaggregator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Search {
    static public List<Game> find(String request) {
        List<Game> result = new ArrayList<Game>();
        for (int i = 0; i < Data.GAMES.size(); ++i) {
            Game game = Data.GAMES.get(i);
            if (game.getName().startsWith(request)) {
                result.add(game);
            }
        }
        return result;
    }
    static public List<Game> find(Category categoryRequest) {
        List<Game> result = new ArrayList<Game>();
        for (int i = 0; i < Data.GAMES.size(); ++i) {
            Game game = Data.GAMES.get(i);
            Map<String, Object> currentGameCategory = game.getCategoryList().getCategoryMap();
            boolean ok = true;
            for (Map.Entry<String, Object> cat : categoryRequest.getCategoryMap().entrySet()) {
                if (cat.getValue() != null) {
                    Object curValueObj = currentGameCategory.get(cat.getKey());
                    if (curValueObj == null) {
                        ok = false;
                        break;
                    }
                    if (cat.getKey().equals("EVENT")) {
                        List<String> values = (List<String>)cat.getValue();
                        List<String> curValue = (List<String>)curValueObj;
                        for (String value : values) {
                            if (!curValue.contains(value)) {
                                ok = false;
                                break;
                            }
                        }
                    } else if (cat.getKey().equals("AGE")){
                        Integer value = (Integer)cat.getValue();
                        Integer curValue = (Integer)curValueObj;
                        if (curValue < value) {
                            ok = false;
                            break;
                        }
                    } else if (cat.getKey().equals("GAME_TYPE")) {
                        Map<String, Object> gameTypeMap = (Map<String, Object>)cat.getValue();
                        Map<String, Object> curGameTypeMap = (Map<String, Object>)curValueObj;
                        if (gameTypeMap.get("ONLINE") != null && curGameTypeMap.get("ONLINE") == null) {
                            ok = false;
                            break;
                        }

                        if (gameTypeMap.get("OFFLINE") != null && curGameTypeMap.get("OFFLINE") == null) {
                            ok = false;
                            break;
                        }
                    }
                    /**
                    else if (cat.getKey().equals("PERSONS_COUNT")) {
                        List<Integer> values = (List<Integer>)cat.getValue();
                        List<Integer> curValues = (List<Integer>)curValueObj;
                    } else if (cat.getKey().equals("DIFFICULTY")) {
                        Integer value = (Integer)cat.getValue();
                        Integer curValue = (Integer)curValueObj;
                    } else if (cat.getKey().equals("TIME")) {
                        List<Integer> values = (List<Integer>)cat.getValue();
                        List<Integer> curValues = (List<Integer>)curValueObj;
                    }
                     **/
                }
            }
            if (ok) {
                result.add(game);
            }
        }
        return result;
    }
}
