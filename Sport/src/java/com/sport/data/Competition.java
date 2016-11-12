/*
 Versenyszam
pl: - 50m sikfutas -> egy olimpian
    - bajnoki fordulo
 */
package com.sport.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author krisztian
 */
public class Competition {
    private String name;
    private String description;
    private Championship championship; //bajnoksag
    private List<Condition> condition = new ArrayList<>(); //megkotesek (nem, eletkor, tomeg, magassag)
    private HashMap<Competitor,List<Competitor>> competitors = new HashMap<>(); //resztvevok
    private List<Race> reces = new ArrayList<>(); //futamok/merkozesek
    
    public Competition(String name, String description) {
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

    public Championship getChampionship() {
        return championship;
    }

    public void setChampionship(Championship championship) {
        this.championship = championship;
    }

    public List<Condition> getCondition() {
        return condition;
    }

    public void setCondition(List<Condition> condition) {
        this.condition = condition;
    }

    public HashMap<Competitor, List<Competitor>> getCompetitors() {
        return competitors;
    }

    public void setCompetitors(HashMap<Competitor, List<Competitor>> competitors) {
        this.competitors = competitors;
    }

    public List<Race> getReces() {
        return reces;
    }

    public void setReces(List<Race> reces) {
        this.reces = reces;
    }
    
}
