package com.sport.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author krisztian
 */
public class Series {
    private String name, description;
    private List<SportType> sportTypes = new ArrayList<>();
    private HashMap<Season,List<Championship>> championships = new HashMap<>();

    public Series(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<SportType> getSportTypes() {
        return sportTypes;
    }

    public void setSportTypes(List<SportType> sportTypes) {
        this.sportTypes = sportTypes;
    }

    public HashMap<Season, List<Championship>> getChampionships() {
        return championships;
    }

    public void setChampionships(HashMap<Season, List<Championship>> championships) {
        this.championships = championships;
    }
    
    
    
}
