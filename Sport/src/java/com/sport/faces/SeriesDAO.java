package com.sport.faces;

import com.sport.data.Season;
import com.sport.data.Series;
import com.sport.data.SportType;
import com.sport.exceptions.InstanceExistException;
import com.sport.exceptions.InstanceNotExistException;
import java.util.List;

/**
 * @author krisztian
 */
public interface SeriesDAO {
    public Series createIfNotExist(String name, String desc, List<SportType> sportTypes) throws InstanceExistException;
    public Series createIfNotExist(String name, String desc, SportType sportType) throws InstanceExistException;
    public List<Series> getAll();    
    public Series getByName(String name) throws InstanceNotExistException;
    public List<Series> getOfSportTypeAndSeason(SportType sportType, Season season) throws InstanceNotExistException;

}
