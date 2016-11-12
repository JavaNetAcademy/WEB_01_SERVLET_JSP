/*
alltalanos resztvevo egy sportversenyen
 */
package com.sport.data;

import java.util.List;

/**
 * @author krisztian
 */
public class Competitor {
    protected String name;
    protected String description;   
    protected List<Race> competition;

    public Competitor() {
    }

    
    public Competitor(String name, String description) {
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

    public List<Race> getCompetition() {
        return competition;
    }

    public void setCompetition(List<Race> Competition) {
        this.competition = Competition;
    }

    
    
    
    
}
