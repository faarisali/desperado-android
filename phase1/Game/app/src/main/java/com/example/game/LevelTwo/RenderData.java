package com.example.game.LevelTwo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RenderData {
    private Map<String, ArrayList<Integer>> data = new HashMap<>();

    public ArrayList<Integer> getData(String key) {
        if (data.containsKey(key)) {
            return data.get(key);
        }
        return new ArrayList<>();

    }

    public void store(String key, int newVal) {
        if (data.containsKey(key)) {
            data.get(key).add(newVal);
        } else {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(newVal);
            data.put(key, temp);
        }
    }


}
