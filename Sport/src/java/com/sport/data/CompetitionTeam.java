package com.sport.data;

/*
csapatsport
 */

/**
 *
 * @author krisztian
 */
public class CompetitionTeam extends Competition{
    private byte numberOfPlayers;
    
    public CompetitionTeam(String name, String description, byte numberOfPlayers) {
        super(name, description);
        this.numberOfPlayers = numberOfPlayers;
    }
    
}
