package com.sport.memory.comparator;

import com.sport.data.Tournament;
import java.util.Comparator;

/**
 * @author krisztian
 */
public class SportTypeComparator implements Comparator<Tournament> {

    @Override
    public int compare(Tournament o1, Tournament o2) {
        return o1.getName().compareTo(o2.getName());
    }
    
}
