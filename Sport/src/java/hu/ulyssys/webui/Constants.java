/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.ulyssys.webui;

/**
 *
 * @author krisztian
 */
public class Constants {
    public static final String SPORTTYPE_COMMAND_ADD="/sporttype/add";
    public static final String SPORTTYPE_COMMAND_LIST="/sporttype/list";
    public static final String FORM_PARAM_NAME="name";
    public static final String FORM_PARAM_DESCRIPTION="desc";
    public static final String FORM_PARAM_RESULTTYPE="result";

    public static final String SEASON_COMMAND_ADD="/season/add";
    public static final String SEASON_COMMAND_LIST="/season/list";

    public static final String SERIES_COMMAND_ADD="/series/add";
    public static final String SERIES_COMMAND_LIST="/series/list";
    public static final String FORM_PARAM_SERIES="series";
            
    public static final String CHAMPIONSHIP_COMMAND_ADD="/championship/add";
    public static final String CHAMPIONSHIP_COMMAND_LIST="/championship/list";
    public static final String FORM_PARAM_SPORTTYPE="sport";
    public static final String FORM_PARAM_SEASON="season";
    
    public static final String COMPETITION_COMMAND_ADD="/competition/add";
    public static final String COMPETITION_COMMAND_LIST="/competition/list";
    public static final String FORM_PARAM_CHAMPIONSHIP="championship";
    
    public static final String RACE_COMMAND_ADD="/race/add";
    public static final String RACE_COMMAND_LIST="/race/list";
    public static final String FORM_PARAM_COMPETITION="competition";
    
}
