package com.example.gameaggregator;

import java.util.ArrayList;
import java.util.List;

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
}
