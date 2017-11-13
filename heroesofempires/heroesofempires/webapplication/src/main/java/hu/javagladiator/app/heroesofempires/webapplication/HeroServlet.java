/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiator.app.heroesofempires.webapplication;

import hu.javagladiators.app.heroesofempires.datamodel.hero.Hero;
import hu.javagladiators.app.heroesofempires.datamodel.hero.HeroService;
import hu.javagladiators.app.heroesofempires.dataservice.fileio.HeroServiceImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author krisztian
 */
@WebServlet(name = "HeroServlet", urlPatterns = {"/hero"})
public class HeroServlet extends HttpServlet {
    HeroService service = new HeroServiceImpl();
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
        request.setAttribute("heroes", service.getMoreOrderByKey(0, (int)service.getSize()));
        request.getRequestDispatcher("/hero.jsp").include(request, response);
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
        Hero tmp =new Hero(
                request.getParameter("name"), 
                request.getParameter("description"), 
                request.getParameter("active")!=null);
        request.getSession().setAttribute("hero", tmp);
        service.add(tmp);
        doGet(request, response);
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
