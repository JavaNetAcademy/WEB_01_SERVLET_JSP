/*
 */
package com.sport.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** *
 * @author krisztian
 */
public class Season {
    private String name;
    private String description;   
    private List<SportType> sports = new ArrayList<>();
    private List<Championship> championships = new ArrayList<>();

    
    public Season(String name, String description) {
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

    public List<SportType> getSports() {
        return sports;
    }

    public void setSports(List<SportType> sports) {
        this.sports = sports;
    }

    public List<Championship> getChampionships() {
        return championships;
    }

    public void setChampionships(List<Championship> championships) {
        this.championships = championships;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.name);
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Season){
            if(this.name.equals(((Season)obj).getName())){
                return true;
            }
        }
        return false;
    }    
}
