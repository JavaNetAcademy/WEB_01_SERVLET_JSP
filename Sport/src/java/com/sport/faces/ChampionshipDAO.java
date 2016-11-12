package com.sport.faces;

import com.sport.data.Championship;
import com.sport.data.Season;
import com.sport.data.Series;
import com.sport.data.SportType;
import com.sport.exceptions.InstanceExistException;
import com.sport.exceptions.InstanceNotExistException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author krisztian
 */
public interface ChampionshipDAO {

    public  List<Championship> getAll();   
    public Championship createIfNotExist(String name, String description, SportType sportype,Season season,Series series) throws InstanceExistException;
    public Championship createIfNotExist(String description, SportType sportype,Season season,Series series) throws InstanceExistException;        
    public Championship getByName(String name) throws NullPointerException,InstanceNotExistException;
        
    
}
