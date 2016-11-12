
package hu.ulyssys.webui;

import com.sport.data.Championship;
import com.sport.data.Competition;
import com.sport.data.Race;
import com.sport.data.ResultType;
import com.sport.data.Season;
import com.sport.data.Series;
import com.sport.data.SportType;
import com.sport.exceptions.InstanceExistException;
import com.sport.exceptions.InstanceNotExistException;
import hu.sport.util.MemoryFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author krisztian
 */
@WebServlet(name = "MainServlet", urlPatterns = {"/admin/*"}, loadOnStartup = 1)
public class AdminServlet extends HttpServlet {

    private static final Logger LOGG = Logger.getLogger(AdminServlet.class.getName());
    private static final String APPLICATION_DATA_MODELL= "dataModel";

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        MemoryFactory instance;
        try {
            instance = new MemoryFactory();
            instance.loadCache();
            getServletContext().setAttribute(APPLICATION_DATA_MODELL,instance);
        } catch (InstanceExistException ex) {
            Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private MemoryFactory getApplicationDataModell(){
        return (MemoryFactory)getServletContext().getAttribute(APPLICATION_DATA_MODELL);
    }
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InstanceNotExistException, InstanceExistException, NullPointerException {

        response.setContentType("text/html;charset=UTF-8");
        System.out.println(request.getPathInfo());
///        request.setCharacterEncoding("UTF-8");
        Enumeration<String> params = request.getParameterNames();
        String key;
        while (params.hasMoreElements()) {
            key = params.nextElement();
            System.out.println(key + ":" + request.getParameter(key));
        }

        SportType sportType = null;
        Season season = null;
        Series series = null;
        Championship championship = null;
        Competition competition = null;
        Race race = null;

        switch (request.getPathInfo()) {
            case Constants.SPORTTYPE_COMMAND_ADD:
                getApplicationDataModell().getSportTypeDAO().registerIfNotExist(
                        request.getParameter(Constants.FORM_PARAM_NAME),
                        request.getParameter(Constants.FORM_PARAM_DESCRIPTION),
                        ResultType.valueOf(request.getParameter(Constants.FORM_PARAM_RESULTTYPE))
                );
                request.setAttribute("page", Constants.SPORTTYPE_COMMAND_LIST);
                break;

            case Constants.SEASON_COMMAND_ADD:
                getApplicationDataModell().getSeasonDAO().registerIfNotExist(
                        request.getParameter(Constants.FORM_PARAM_NAME),
                        request.getParameter(Constants.FORM_PARAM_DESCRIPTION)
                );
                request.setAttribute("page", Constants.SEASON_COMMAND_LIST);
                break;
                
            case Constants.SERIES_COMMAND_ADD:
                String[] sports = request.getParameterValues(Constants.FORM_PARAM_SPORTTYPE);
                List<SportType> selectedSports = new ArrayList<SportType>();
                for(String s:sports){
                    selectedSports.add(getApplicationDataModell().getSportTypeDAO().getByName(s));
                }
                getApplicationDataModell().getSeriesDAO().createIfNotExist(
                        request.getParameter(Constants.FORM_PARAM_NAME),
                        request.getParameter(Constants.FORM_PARAM_DESCRIPTION),
                        selectedSports
                );
                request.setAttribute("page", Constants.SERIES_COMMAND_LIST);
                break;

            case Constants.CHAMPIONSHIP_COMMAND_ADD:
                sportType = getApplicationDataModell().getSportTypeDAO().getByName(request.getParameter(Constants.FORM_PARAM_SPORTTYPE));
                season = getApplicationDataModell().getSeasonDAO().getByName(request.getParameter(Constants.FORM_PARAM_SEASON));
                series = getApplicationDataModell().getSeriesDAO().getByName(request.getParameter(Constants.FORM_PARAM_SERIES));
                getApplicationDataModell().getChampionshipDAO().createIfNotExist(
                        request.getParameter(Constants.FORM_PARAM_NAME),
                        request.getParameter(Constants.FORM_PARAM_DESCRIPTION),
                        sportType,
                        season,
                        series
                );
                request.setAttribute("selectedSportType", sportType);
                request.setAttribute("selectedSeason", season);
                request.setAttribute("selectedSeries", series);
                request.setAttribute("championships", series.getChampionships().get(season));
                request.setAttribute("page", Constants.CHAMPIONSHIP_COMMAND_LIST);
                break;

            case Constants.CHAMPIONSHIP_COMMAND_LIST:
                sportType = getApplicationDataModell().getSportTypeDAO().getByName(request.getParameter(Constants.FORM_PARAM_SPORTTYPE));
                season = getApplicationDataModell().getSeasonDAO().getByName(request.getParameter(Constants.FORM_PARAM_SEASON));
                series = getApplicationDataModell().getSeriesDAO().getByName(request.getParameter(Constants.FORM_PARAM_SERIES));

                if (sportType != null && season != null  && series != null) {
                    request.setAttribute("selectedSportType", sportType);
                    request.setAttribute("selectedSeason", season);
                    request.setAttribute("selectedSeries", series);
                    request.setAttribute("championships", series.getChampionships().get(season));
                    request.setAttribute("page", Constants.CHAMPIONSHIP_COMMAND_LIST);
                } else {
                    request.setAttribute("page", Constants.CHAMPIONSHIP_COMMAND_LIST);
                }
                break;

            case Constants.COMPETITION_COMMAND_ADD:
                sportType = getApplicationDataModell().getSportTypeDAO().getByName(request.getParameter(Constants.FORM_PARAM_SPORTTYPE));
                season = getApplicationDataModell().getSeasonDAO().getByName(request.getParameter(Constants.FORM_PARAM_SEASON));
                series = getApplicationDataModell().getSeriesDAO().getByName(request.getParameter(Constants.FORM_PARAM_SERIES));
                championship = getApplicationDataModell().getChampionshipDAO().getByName(request.getParameter(Constants.FORM_PARAM_CHAMPIONSHIP));
                getApplicationDataModell().getCompetitionDAO().createIfNotExist(
                        request.getParameter(Constants.FORM_PARAM_NAME),
                        request.getParameter(Constants.FORM_PARAM_DESCRIPTION),
                        championship
                );
                request.setAttribute("selectedSportType", sportType);
                request.setAttribute("selectedSeason", season);
                request.setAttribute("championships", series.getChampionships().get(season));
                request.setAttribute("page", Constants.COMPETITION_COMMAND_LIST);
                break;

            case Constants.COMPETITION_COMMAND_LIST:
                sportType = getApplicationDataModell().getSportTypeDAO().getByName(request.getParameter(Constants.FORM_PARAM_SPORTTYPE));
                season = getApplicationDataModell().getSeasonDAO().getByName(request.getParameter(Constants.FORM_PARAM_SEASON));
                series = getApplicationDataModell().getSeriesDAO().getByName(request.getParameter(Constants.FORM_PARAM_SERIES));
                championship = getApplicationDataModell().getChampionshipDAO().getByName(request.getParameter(Constants.FORM_PARAM_CHAMPIONSHIP));

                if (sportType != null && season != null && championship != null) {
                    request.setAttribute("selectedSportType", sportType);
                    request.setAttribute("selectedSeason", season);
                    request.setAttribute("selectedChampionship", championship);
                    request.setAttribute("competitions", championship.getCompetitions());
                }
                request.setAttribute("page", Constants.COMPETITION_COMMAND_LIST);
                break;
                
            case Constants.RACE_COMMAND_ADD:
                championship = getApplicationDataModell().getChampionshipDAO().getByName(request.getParameter(Constants.FORM_PARAM_CHAMPIONSHIP));
                String selectedCompetiton = request.getParameter(Constants.FORM_PARAM_COMPETITION);
                if(selectedCompetiton == null || selectedCompetiton.isEmpty()){                
                    request.setAttribute("selectedChampionship", championship);
                    request.setAttribute("page", Constants.RACE_COMMAND_ADD);
                }
                else{
                    competition = getApplicationDataModell().getCompetitionDAO().getByName(championship, request.getParameter(Constants.FORM_PARAM_COMPETITION));
                    getApplicationDataModell().getRaceDAO().createIfNotExist(request.getParameter(Constants.FORM_PARAM_NAME), request.getParameter(Constants.FORM_PARAM_DESCRIPTION), competition);
                    request.setAttribute("page", Constants.RACE_COMMAND_LIST);
                }
                break;
                
            case Constants.RACE_COMMAND_LIST:
                sportType = getApplicationDataModell().getSportTypeDAO().getByName(request.getParameter(Constants.FORM_PARAM_SPORTTYPE));
                season = getApplicationDataModell().getSeasonDAO().getByName(request.getParameter(Constants.FORM_PARAM_SEASON));
                championship = getApplicationDataModell().getChampionshipDAO().getByName(request.getParameter(Constants.FORM_PARAM_CHAMPIONSHIP));
                competition = getApplicationDataModell().getCompetitionDAO().getByName(championship, request.getParameter(Constants.FORM_PARAM_COMPETITION));

                if (sportType != null && season != null && championship != null && competition != null) {
                    request.setAttribute("selectedSportType", sportType);
                    request.setAttribute("selectedSeason", season);
                    request.setAttribute("selectedChampionship", championship);
                    request.setAttribute("selectedCompetition", competition);
                    request.setAttribute("races", getApplicationDataModell().getRaceDAO().getRaces(championship, competition));
                }
                request.setAttribute("page", Constants.RACE_COMMAND_LIST);
                break;

        }

        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{processRequest(request, response);}
        catch(InstanceNotExistException | InstanceExistException | NullPointerException e){
            request.setAttribute("page","error");
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            e.printStackTrace();
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{processRequest(request, response);}
        catch(InstanceNotExistException | InstanceExistException | NullPointerException e){
            request.setAttribute("page","error");
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            e.printStackTrace();
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
