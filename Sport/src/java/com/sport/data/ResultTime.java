/*
 */
package com.sport.data;

import java.time.Duration;

/**
 *
 * @author krisztian
 */
public class ResultTime extends Result{
    Duration time;

    public ResultTime(Competitor competitor, Duration time) {
        this.competitor = competitor;
        this.time = time;
    }
    
    
}
