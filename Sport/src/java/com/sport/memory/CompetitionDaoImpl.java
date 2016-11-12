/*
 */
package com.sport.memory;

import com.sport.exceptions.InstanceExistException;
import com.sport.exceptions.InstanceNotExistException;
import com.sport.data.Championship;
import com.sport.data.Competition;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author krisztian
 */
public class CompetitionDaoImpl implements com.sport.faces.CompetitionDAO {
    private static final Logger LOGG = Logger.getLogger(CompetitionDaoImpl.class.getName());
    
    public CompetitionDaoImpl() {
    
    }
    
    public Competition createIfNotExist(String name, String description, Championship championship) throws InstanceNotExistException,InstanceExistException{
            boolean exist = false;
            Competition competition;
            for(int i=0;i<championship.getCompetitions().size() && !exist; i++){
                competition = championship.getCompetitions().get(i);
                exist = competition.getName().equals(name);
            }
            if(!exist){
                Competition newCompetition = new Competition(name, description);
                championship.getCompetitions().add(newCompetition);
                return newCompetition;
            }
            else throw new InstanceExistException(name);
    }
    
    
    
    public Competition getByName(Championship championship,String name) throws NullPointerException, InstanceNotExistException{
        for(Competition cmp:championship.getCompetitions())
            if(cmp.getName().equals(name))
                return cmp;
        throw new InstanceNotExistException(name);
    }
    
    
    public List<Competition> getALL(){
        return new ArrayList<Competition>();
        
    }
}
