package com.example.game.LevelTwo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * The replay information at one tick (or one moment).
 */
public class RenderData {
    private Map<String, ArrayList<Integer>> data = new HashMap<>();

    /**
     * Retrieve information which was previously stored. If key is not found, empty list is returned.
     * @param key the reference corresponding to the information which needs to be retrieved.
     * @return the ArrayList<Integer> that corresponds to key.
     */
    public ArrayList<Integer> getData(String key) {
        if (data.containsKey(key)) {
            return data.get(key);
        }
        return new ArrayList<>();
    }


    /**
     * Precondition: format of parameter entry must follow the format of the output of
     * RenderData.generateStorable.
     *
     * @param entry the string that specifies to object to be created.
     * @return RenderData instance
     */
    public static RenderData toRenderData(String entry) {
        RenderData dataOutput = new RenderData();
        String stringMap = entry.split("@")[1];
        String[] keyValuePairs = stringMap.split("!");
        for (int i = 0; i < keyValuePairs.length; i++) {
            String[] values = keyValuePairs[i].split(",");
            String key = values[0];
            for (int j = 1; j < values.length; j++) {
                dataOutput.store(key, Integer.parseInt(values[j]));
            }
        }
        return dataOutput;
    }

    /**
     * Store the key-value pair.
     * @param key the reference that will be used to retrieve the information stored.
     * @param value the ArrayList<Integer> to be stored.
     */
    public void store(String key, ArrayList<Integer> value) {
        data.put(key, value);
    }

    /**
     * Store the key-value pair.
     * @param key the reference that will be used to retrieve the information stored.
     * @param newVal and integer to store.
     */
    public void store(String key, int newVal) {
        if (data.containsKey(key)) {
            data.get(key).add(newVal);
        } else {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(newVal);
            data.put(key, temp);
        }
    }

    /**
     * Return a string representation for storage.
     *
     * @param name denotes a name for the RenderData object.
     * @return a string representation of RenderData.
     * Format: "Name@Key1,item1,item2...!Key2,item1 ... "
     */

    public String generateStorable(String name) {
        StringBuilder stringStorable = new StringBuilder();
        stringStorable.append(name);
        stringStorable.append("@");
        for (Map.Entry<String, ArrayList<Integer>> entry : data.entrySet()) {
            StringBuilder temp = new StringBuilder();
            temp.append(entry.getKey());
            ArrayList<Integer> value = entry.getValue();
            for (int dataEntries : value) {
                temp.append(",");
                temp.append(dataEntries);
            }
            stringStorable.append(temp);
            stringStorable.append("!");
        }
        stringStorable.deleteCharAt(stringStorable.length() - 1);
        return stringStorable.toString();

    }


}
