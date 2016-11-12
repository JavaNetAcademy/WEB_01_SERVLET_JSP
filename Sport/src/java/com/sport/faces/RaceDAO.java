package com.sport.faces;

import com.sport.data.Championship;
import com.sport.data.Competition;
import com.sport.data.Race;
import com.sport.exceptions.InstanceExistException;
import com.sport.exceptions.InstanceNotExistException;
import java.util.List;

/**
 * @author krisztian
 */
public interface RaceDAO {
    public Race createIfNotExist(String name, String description, Competition competition) throws InstanceNotExistException,InstanceExistException;
    public List<Race> getRaces(Championship championship, Competition competition) throws InstanceNotExistException;
}
