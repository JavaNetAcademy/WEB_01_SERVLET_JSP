/*
 */
package com.sport.data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author krisztian
 */
public class CompetitorTeam extends Competitor{
    List<Competitor> members = new ArrayList<>();
    
    
    public CompetitorTeam() {
        super();
    }
    public CompetitorTeam(String name, String description) {
        super(name, description);
    }


    public List<Competitor> getMembers() {
        return members;
    }

    public void setMembers(List<Competitor> members) {
        this.members = members;
    }
    
    
}
