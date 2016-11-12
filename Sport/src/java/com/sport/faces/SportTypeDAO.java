package com.sport.faces;

import com.sport.data.ResultType;
import com.sport.data.SportType;
import com.sport.exceptions.InstanceExistException;
import com.sport.exceptions.InstanceNotExistException;
import java.util.List;

/**
 * @author krisztian
 */
public interface SportTypeDAO {

    public List<SportType> getAll();   
    public SportType registerIfNotExist(String pName, String pDesc, ResultType pType ) throws InstanceExistException;    
    public SportType getByName(String name) throws InstanceNotExistException;
    public boolean contains(SportType sportType);
    
}
