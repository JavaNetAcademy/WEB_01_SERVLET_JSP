/*
 */
package com.sport.memory;

import com.sport.exceptions.InstanceExistException;
import com.sport.exceptions.InstanceNotExistException;
import com.sport.data.Championship;
import com.sport.data.Competition;
import com.sport.data.Race;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author krisztian
 */
public class RaceDaoImpl implements com.sport.faces.RaceDAO {
    private static final Logger LOGG = Logger.getLogger(CompetitionDaoImpl.class.getName());
    
    
    public Race createIfNotExist(String name, String description, Competition competition) throws InstanceNotExistException,InstanceExistException{
            boolean exist = false;
            Race race;
            for(int i = 0; i<competition.getReces().size() && !exist; i++){
                race = competition.getReces().get(i);
                exist = race.getName().equals(name);
            }
            if(!exist){
                Race newRace = new Race(name, description);
                competition.getReces().add(newRace);
                return newRace;
            }
            else throw new InstanceExistException(name);
    }
    
    
    public List<Race> getRaces(Championship championship, Competition competition) throws InstanceNotExistException{
                for(Competition cmp:championship.getCompetitions())
                    if(cmp.equals(competition))
                        return cmp.getReces();
        throw new InstanceNotExistException(competition.getName());
    }
    

}
