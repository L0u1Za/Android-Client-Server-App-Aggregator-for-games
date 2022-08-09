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
                boolean curOk = false;
                if (cat.getValue() != null) {
                    Object curValueObj = currentGameCategory.get(cat.getKey());
                    if (curValueObj == null) {
                        ok = false;
                        break;
                    }
                    if (cat.getKey().equals("EVENT")) {
                        curValueObj = (List<String>)currentGameCategory.get(cat.getKey());
                        List<String> curValues = (List<String>)cat.getValue();
                        List<String> gameValues = (List<String>)curValueObj;
                        for (String value : curValues) {
                            if (gameValues.contains(value)) {
                                curOk = true;
                                break;
                            }
                        }
                    } else if (cat.getKey().equals("AGE")){
                        List<Integer> curValues = (List<Integer>)cat.getValue();
                        Integer gameValue = (Integer)curValueObj;
                        for (Integer curValue : curValues) {
                            if (curValue >= gameValue) {
                                curOk = true;
                                break;
                            }
                        }
                    } else if (cat.getKey().equals("GAME_TYPE")) {
                        Map<String, Object> curTypeMap = (Map<String, Object>)cat.getValue();
                        Map<String, Object> gameTypeMap = (Map<String, Object>)curValueObj;
                        if (curTypeMap.get("ONLINE") != null && gameTypeMap.get("ONLINE") == null) {
                            curOk = false;
                        } else if (curTypeMap.get("OFFLINE") != null && gameTypeMap.get("OFFLINE") == null) {
                            curOk = false;
                        } else {
                            curOk = true;
                        }
                    } else {
                        curOk = true;
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
                ok &= curOk;
            }
            if (ok) {
                result.add(game);
            }
        }
        return result;
    }
}
