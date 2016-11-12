/*
Egy esemeny a sportversenyen
*/
package com.sport.data;

import java.time.Duration;

/**
 * @author krisztian
 */
public class Event {
    Competitor competitor;
    String key;
    Duration moment;
    
    
    public Event(Competitor competitor, String key, Duration value) {
        this.competitor = competitor;
        this.key = key;
        this.moment = value;
    }

    public Competitor getCompetitor() {
        return competitor;
    }

    public void setCompetitor(Competitor competitor) {
        this.competitor = competitor;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Duration getMoment() {
        return moment;
    }

    public void setMoment(Duration value) {
        this.moment = value;
    }
    
    
    
}
