/*
 */
package hu.ulyssys.tld;

import com.sport.data.SportType;
import com.sport.util.AbstractFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

/**
 * @author krisztian
 */
public class SportTypeSelectTag extends BodyTagSupport{
    private static final String SESSION_SPORT_TYPE = "sporttype";
    private static final String APPLICATION_DATA_MODELL= "dataModel";
    private String name="";
    private String cssClass="";
    private String id="";
    private String aria="";
    
    public void setName(String name){this.name=name;}
    public void setCss(String name){this.cssClass=name;}
    public void setId(String name){this.id=name;}
    public void setAria(String name){this.aria=name;}
    
    @Override
    public int doStartTag() throws JspException {
        try {
                pageContext.getOut().println("<select class=\""+cssClass+"\" id=\""+id+"\" aria-describedby=\""+aria+"\" ");
        } 
        catch (IOException ex) {Logger.getLogger(SportTypeSelectTag.class.getName()).log(Level.SEVERE, null, ex);}
        return EVAL_BODY_TAG;
    }

    @Override
    public void doInitBody() throws JspException {}

    
    @Override
    public int doAfterBody() throws JspException {
         return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        
        try{
            pageContext.getOut().println("name=\""+name+"\" >");
            SportType selectedSport=(SportType)pageContext.getSession().getAttribute(SESSION_SPORT_TYPE);
            AbstractFactory dataModel=(AbstractFactory)pageContext.getServletContext().getAttribute(APPLICATION_DATA_MODELL);
            for(SportType sportType:dataModel.getSportTypeDAO().getAll()){
                if(selectedSport != null && sportType.getName().equals(selectedSport.getName())){
                    pageContext.getOut().println("<option selected value=\""+sportType.getName()+"\">"+sportType.getName()+"</option>");
                }
                else{
                    pageContext.getOut().println("<option value=\""+sportType.getName()+"\">"+sportType.getName()+"</option>");
                }
            }
            pageContext.getOut().println("</select>");
        } 
        catch (IOException ex) {Logger.getLogger(SportTypeSelectTag.class.getName()).log(Level.SEVERE, null, ex);}
        return EVAL_PAGE;
    }
    
    
    
    
    
}
