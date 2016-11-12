package com.sport.faces;

import com.sport.data.Championship;
import com.sport.data.Competition;
import com.sport.exceptions.InstanceExistException;
import com.sport.exceptions.InstanceNotExistException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author krisztian
 */
public interface CompetitionDAO {


    public Competition createIfNotExist(String name, String description, Championship championship) throws InstanceNotExistException,InstanceExistException;
    public Competition getByName(Championship championship,String name) throws NullPointerException, InstanceNotExistException;
    public List<Competition> getALL(); 
    
}
