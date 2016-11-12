package com.sport.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author krisztian
 */
public class Tournament {
    private String name;
    private String description;
    private List<SportType> sporTypes = new ArrayList<>();    

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

    public List<SportType> getSporTypes() {
        return sporTypes;
    }

    public void setSporTypes(List<SportType> sporTypes) {
        this.sporTypes = sporTypes;
    }

    public HashMap<Season, Championship> getChampionships() {
        return championships;
    }

    public void setChampionships(HashMap<Season, Championship> championships) {
        this.championships = championships;
    }
    private HashMap<Season,Championship> championships = new HashMap<>();

    public Tournament(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    
}
