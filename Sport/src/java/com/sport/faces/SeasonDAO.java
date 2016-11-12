package com.sport.faces;

import com.sport.data.Season;
import com.sport.data.SportType;
import com.sport.exceptions.InstanceExistException;
import com.sport.exceptions.InstanceNotExistException;
import java.util.List;

/**
 * @author krisztian
 */
public interface SeasonDAO {
    public List<Season> getAll();    
    public Season registerIfNotExist(String name, String description) throws InstanceExistException;
    public Season getByName(String name) throws InstanceNotExistException;
    public boolean contains(Season season);
    
}
