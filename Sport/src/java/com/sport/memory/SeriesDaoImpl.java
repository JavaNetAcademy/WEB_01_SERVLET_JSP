/*
 */
package com.sport.memory;

import com.sport.data.Season;
import com.sport.exceptions.InstanceExistException;
import com.sport.exceptions.InstanceNotExistException;
import com.sport.data.Series;
import com.sport.data.SportType;
import java.util.ArrayList;
import java.util.List;

/**
 * @author krisztian
 */
public class SeriesDaoImpl implements com.sport.faces.SeriesDAO {
    private static final List<Series> SERIES = new ArrayList<>();
    
    @Override
    public Series createIfNotExist(String name, String desc, List<SportType> sportTypes) throws InstanceExistException{
        for(Series t:SERIES)
            if(t.getName().equals(name))
                throw new InstanceExistException(name);
        Series tmp = new Series(name, desc);
        tmp.setSportTypes(sportTypes);
        SERIES.add(tmp);
        return tmp;
    }

    @Override
    public Series createIfNotExist(String name, String desc, SportType sportType) throws InstanceExistException{
        for(Series t:SERIES)
            if(t.getName().equals(name))
                throw new InstanceExistException(name);
        Series tmp = new Series(name, desc);
        tmp.getSportTypes().add(sportType);
        SERIES.add(tmp);
        return tmp;
    }
    
    @Override
    public List<Series> getAll(){return SERIES;}
    
    @Override
    public Series getByName(String name) throws InstanceNotExistException{
        for(Series t:SERIES)
            if(t.getName().equals(name))
                    return t;
        throw new InstanceNotExistException(name);
    }
    
        @Override
    public List<Series> getOfSportTypeAndSeason(SportType sportType, Season season) throws InstanceNotExistException {
        
        List<Series> res = new ArrayList<>();
        for(Series item:SERIES){
            if(
                item.getSportTypes().indexOf(sportType)>(-1) &&
                item.getChampionships().get(season) != null
            ){
                res.add(item);
            }    
        }
        return res;
    }

}
