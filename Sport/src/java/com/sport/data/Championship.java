/*
Egy verseny. 
pl: - Forma1-es futam
    - Labdarugo bajnokság/kupa/vb
    - olimpia
 */
package com.sport.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author krisztian
 */
public class Championship {
    private String name;
    private String description;
    
    private SportType sporType;
   
    private Season season;
    
    private List<Competitor> competitors = new ArrayList<>();
    private List<Competition> competitions = new ArrayList<>();
//@HowTo aktualis eredmeny
    
    public Championship(String name, String description) {
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

    public SportType getSportypes() {
        return sporType;
    }

    public void setSportype(SportType sportype) {
        this.sporType = sportype;
    }



    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public List<Competitor> getCompetitors() {
        return competitors;
    }

    public void setCompetitors(List<Competitor> competitors) {
        this.competitors = competitors;
    }

    public List<Competition> getCompetitions() {
        return competitions;
    }

    public void setCompetitions(List<Competition> competitions) {
        this.competitions = competitions;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.name);
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Championship)
            if(this.name.equals(((Championship)obj).getName()))
                return true;
        return false;
    }
    
}
