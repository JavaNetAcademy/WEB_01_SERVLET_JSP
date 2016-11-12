/*
 */
package com.sport.memory;

import com.sport.exceptions.InstanceExistException;
import com.sport.exceptions.InstanceNotExistException;
import com.sport.data.Season;
import com.sport.data.SportType;
import java.util.ArrayList;
import java.util.List;

/**
 * @author krisztian
 */
public class SeasonDaoImpl implements com.sport.faces.SeasonDAO {

    private static final List<Season> SEASONS = new ArrayList<>();


    
    @Override
    public List<Season> getAll() {return SEASONS;}
    
    @Override
    public Season registerIfNotExist(String name, String description) throws InstanceExistException{
        Season res = new Season(name, description);
        if(SEASONS.contains(res)){
            throw new InstanceExistException("");
        }
        SEASONS.add(res);
        return res;
    }    

    @Override
    public Season getByName(String name) throws InstanceNotExistException{
        for(final Season season : SEASONS){
            final String seasonName = season.getName();
            if(seasonName != null && seasonName.equals(name)){
                return season;
            }
        }
        throw new InstanceNotExistException("Season not found (" + name + ")");
    }
    
    @Override
    public boolean contains(Season season){
        return SEASONS.contains(season);
    }


    
    
    
}
