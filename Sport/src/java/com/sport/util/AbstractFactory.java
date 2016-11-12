package com.sport.util;

import com.sport.faces.ChampionshipDAO;
import com.sport.faces.CompetitionDAO;
import com.sport.faces.CompetitorDAO;
import com.sport.faces.RaceDAO;
import com.sport.faces.SeasonDAO;
import com.sport.faces.SeriesDAO;
import com.sport.faces.SportTypeDAO;


/**
 * @author krisztian
 */
public interface AbstractFactory {
    public SportTypeDAO getSportTypeDAO();
    public SeasonDAO getSeasonDAO();
    public ChampionshipDAO getChampionshipDAO();
    public CompetitionDAO getCompetitionDAO();
    public CompetitorDAO getCompetitorDAO();
    public RaceDAO getRaceDAO();
    public SeriesDAO getSeriesDAO();
    
    public void loadCache();
    
}
