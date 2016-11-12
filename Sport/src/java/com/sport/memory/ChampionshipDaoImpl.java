/*
 */
package com.sport.memory;

import com.sport.exceptions.InstanceExistException;
import com.sport.exceptions.InstanceNotExistException;
import com.sport.data.Championship;
import com.sport.data.Season;
import com.sport.data.Series;
import com.sport.data.SportType;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author krisztian
 */
public class ChampionshipDaoImpl implements com.sport.faces.ChampionshipDAO {
    private static final Logger LOGG = Logger.getLogger(ChampionshipDaoImpl.class.getName());
    private static final List<Championship> CHAMPIONSHIP = new ArrayList<>();
    
    
    
    public  List<Championship> getAll() {
        return CHAMPIONSHIP;
    }
   

    public Championship createIfNotExist(String name, String description, SportType sportype,Season season,Series series) throws InstanceExistException{    
        Championship tmp = new Championship(name, description);
        tmp.setSportype(sportype);
        tmp.setSeason(season);
        CHAMPIONSHIP.add(tmp);
        if(series.getChampionships().get(season)==null)
            series.getChampionships().put(season,new ArrayList<Championship>());
        series.getChampionships().get(season).add(tmp);
        return tmp;
    }

    public Championship createIfNotExist(String description, SportType sportype,Season season,Series series) throws InstanceExistException{    
        Championship tmp = new Championship(series.getName()+" "+season.getName() +"("+sportype.getName()+")", description);
        tmp.setSportype(sportype);
        tmp.setSeason(season);
        CHAMPIONSHIP.add(tmp);
        if(series.getChampionships().get(season)==null)
            series.getChampionships().put(season,new ArrayList<Championship>());
        series.getChampionships().get(season).add(tmp);
        return tmp;
    }
    
    
    public Championship getByName(String name) throws NullPointerException,InstanceNotExistException{
        for(Championship tmp:CHAMPIONSHIP){
            if(tmp.getName().equals(name))
                return tmp;
        }
        throw new InstanceNotExistException(name);
    }
    
    
}
