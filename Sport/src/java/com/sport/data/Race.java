/*
futam, mecss, sorosolas utan van ilyen
 */
package com.sport.data;

import java.sql.Time;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author krisztian
 */
public class Race {
    Date statdate;
    Time startTime;

    Date endDate;
    Time endTime;

    String name;
    String description;    
    List<Result> results;
    
    Competition competition;
    HashMap<Competitor,List<Competitor>> competitors; 
    HashMap<Competitor,List<Event>> events;
    
    public Race(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Date getStatdate() {
        return statdate;
    }

    public void setStatdate(Date statdate) {
        this.statdate = statdate;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
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

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public HashMap<Competitor, List<Competitor>> getCompetitors() {
        return competitors;
    }

    public void setCompetitors(HashMap<Competitor, List<Competitor>> competitors) {
        this.competitors = competitors;
    }
    
    
}
