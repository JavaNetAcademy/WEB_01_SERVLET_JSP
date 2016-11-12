/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.sport.util;

import com.sport.exceptions.InstanceExistException;
import com.sport.data.Championship;
import com.sport.data.Competition;
import com.sport.data.Race;
import com.sport.data.ResultType;
import com.sport.data.Series;
import com.sport.data.SportType;
import com.sport.memory.ChampionshipDaoImpl;
import com.sport.memory.CompetitionDaoImpl;
import com.sport.memory.CompetitorDaoImpl;
import com.sport.memory.RaceDaoImpl;
import com.sport.memory.SeasonDaoImpl;
import com.sport.memory.SeriesDaoImpl;
import com.sport.memory.SportTypeDaoImpl;
import com.sport.util.AbstractFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author krisztian
 */
public class MemoryFactory implements AbstractFactory{
    
    
    private final com.sport.faces.SportTypeDAO sportTypeDAO = new SportTypeDaoImpl();
    private final com.sport.faces.SeasonDAO seasonDAO = new SeasonDaoImpl();
    private final com.sport.faces.ChampionshipDAO championshipDAO = new ChampionshipDaoImpl();
    private final com.sport.faces.CompetitionDAO competitionDAO = new CompetitionDaoImpl();
    private final com.sport.faces.CompetitorDAO competitorDAO = new CompetitorDaoImpl();
    private final com.sport.faces.RaceDAO raceDAO = new RaceDaoImpl();
    private final com.sport.faces.SeriesDAO seriesDAO = new SeriesDaoImpl();
    
    


    public MemoryFactory() throws InstanceExistException {
    }
    
    

    @Override
    public com.sport.faces.SportTypeDAO getSportTypeDAO() {
        return sportTypeDAO;
    }

    @Override
    public com.sport.faces.SeasonDAO getSeasonDAO() {
        return seasonDAO;
    }

    @Override
    public com.sport.faces.ChampionshipDAO getChampionshipDAO() {
        return championshipDAO;
    }

    @Override
    public com.sport.faces.CompetitionDAO getCompetitionDAO() {
        return competitionDAO;
    }

    @Override
    public com.sport.faces.CompetitorDAO getCompetitorDAO() {
        return competitorDAO;
    }

    @Override
    public com.sport.faces.RaceDAO getRaceDAO() {
        return raceDAO;
    }

    @Override
    public com.sport.faces.SeriesDAO getSeriesDAO() {
        return seriesDAO;
    }

    @Override
    public void loadCache() {
        Championship tmp;
        Series series;
        SportType sport;
        try {
            seasonDAO.registerIfNotExist("2016", "...");
            seasonDAO.registerIfNotExist("2016/17", "...");

            sport = sportTypeDAO.registerIfNotExist("Labdarúgás", "...", ResultType.NUMBER);
                series = seriesDAO.createIfNotExist("Premier League", "...", sport);
                    tmp = championshipDAO.createIfNotExist("..", sport, seasonDAO.getAll().get(1),series);
                        tmp.getCompetitions().add(new Competition("1. forduló", "bajnoki forduló"));
                        tmp.getCompetitions().add(new Competition("2. forduló", "bajnoki forduló"));     
                        tmp.getCompetitions().add(new Competition("3. forduló", "bajnoki forduló"));     
                        tmp.getCompetitions().add(new Competition("4. forduló", "bajnoki forduló"));     
                        tmp.getCompetitions().add(new Competition("5. forduló", "bajnoki forduló"));     
                
                series = seriesDAO.createIfNotExist("Bundesliga", "...", sportTypeDAO.getAll().get(0));
                    tmp = championshipDAO.createIfNotExist("..", sportTypeDAO.getAll().get(0), seasonDAO.getAll().get(1),series);
                series = seriesDAO.createIfNotExist("La Liga", "...", sportTypeDAO.getAll().get(0));
                    tmp = championshipDAO.createIfNotExist("..", sportTypeDAO.getAll().get(0), seasonDAO.getAll().get(1),series);
                        
            sport = sportTypeDAO.registerIfNotExist("Úszás", "...", ResultType.TIME);            
            sport = sportTypeDAO.registerIfNotExist("Távolugrás", "...", ResultType.NUMBER);
            

            List<SportType> ost=new ArrayList<>();
            ost.add(sportTypeDAO.getAll().get(0));
            ost.add(sportTypeDAO.getAll().get(1));
            ost.add(sportTypeDAO.getAll().get(2));
                series = seriesDAO.createIfNotExist("Olimpia", "...", ost);
                    tmp = championshipDAO.createIfNotExist("férfi 50m gyors", "...", sportTypeDAO.getAll().get(1), seasonDAO.getAll().get(0), series);
                        tmp.getCompetitions().add(new Competition("Döntő", "Verseny"));
                            tmp.getCompetitions().get(0).getReces().add(new Race("döntő futam", ".."));
                        tmp.getCompetitions().add(new Competition("Elődöntő", "Verseny"));
                            tmp.getCompetitions().get(1).getReces().add(new Race("1 futam", ".."));
                            tmp.getCompetitions().get(1).getReces().add(new Race("2 futam", ".."));
                    tmp = championshipDAO.createIfNotExist("férfi 50m gyors", "...", sportTypeDAO.getAll().get(0), seasonDAO.getAll().get(0), series);
                        tmp.getCompetitions().add(new Competition("Csoport mérkőzések", "Verseny"));
                        tmp.getCompetitions().add(new Competition("Elődöntő", "Verseny"));
                        tmp.getCompetitions().add(new Competition("Döntő", "Verseny"));
            
            sport = sportTypeDAO.registerIfNotExist("Auto-Motor sport", "...", ResultType.TIME);
                series = seriesDAO.createIfNotExist("Világbajnokság", "...", sport);
                    tmp = championshipDAO.createIfNotExist("Formula 1 Világbajnokság", "..", sportTypeDAO.getAll().get(1), seasonDAO.getAll().get(0),seriesDAO.getAll().get(4));
                        tmp.getCompetitions().add(new Competition("Hungaroring", "GP"));
                            tmp.getCompetitions().get(0).getReces().add(new Race("Szabadedzés 1", "GP"));
                            tmp.getCompetitions().get(0).getReces().add(new Race("Szabadedzés 2", "GP"));
                            tmp.getCompetitions().get(0).getReces().add(new Race("Időmérő", "GP"));
                            tmp.getCompetitions().get(0).getReces().add(new Race("Futam", "GP"));
                        tmp.getCompetitions().add(new Competition("Spa", "GP"));
                        tmp.getCompetitions().add(new Competition("Monza", "GP"));


    
            
            
        } catch (InstanceExistException ex) {
            Logger.getLogger(MemoryFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }

    
}
