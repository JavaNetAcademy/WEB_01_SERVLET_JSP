/*
 */
package com.sport.memory;

import com.sport.exceptions.InstanceExistException;
import com.sport.exceptions.InstanceNotExistException;
import com.sport.data.ResultType;
import com.sport.data.SportType;
import java.util.ArrayList;
import java.util.List;

/**
 * @author krisztian
 */
public class SportTypeDaoImpl implements com.sport.faces.SportTypeDAO {
    private static final List<SportType> SPORT_TYPES = new ArrayList<>();

    @Override
    public List<SportType> getAll() {
        return SPORT_TYPES;
    }
    
    @Override
    public SportType registerIfNotExist(String pName, String pDesc, ResultType pType ) throws InstanceExistException{
        SportType res = new SportType(pName, pDesc, pType);
        if(SPORT_TYPES.contains(res)){
            throw new InstanceExistException("");
        }
        SPORT_TYPES.add(res);
        return res;
    }
    
    @Override
    public SportType getByName(String name) throws InstanceNotExistException{
        int index = SPORT_TYPES.indexOf(new SportType(name,"",ResultType.FLOAT_NUMBER));
        if(index >= 0) {
            return SPORT_TYPES.get(index);
        }
        throw new InstanceNotExistException("");
    }
    
    @Override
    public boolean contains(SportType sportType){
        return SPORT_TYPES.contains(sportType);
    }
    
}
