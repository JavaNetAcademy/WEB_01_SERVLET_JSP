/*
 */
package com.sport.data;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author krisztian
 */

public class SportType {
    String name;
    String desciption;
    ResultType resultType;

    public SportType() {
    }
    
    
    public SportType(String name, String desciption, ResultType resultType) {
        this.name = name;
        this.desciption = desciption;
        this.resultType = resultType;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }


    @Override
    public boolean equals(Object obj) {
        if(obj instanceof SportType){
            if(this.name.equals(((SportType)obj).getName())){
                return true;
            }
        }
        return false;
    }
    
    
   
    
    
}
