package edu.wctc.dfb.bookwebappmaven.controller;

import edu.wctc.dfb.bookwebappmaven.model.AuthorService;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dan
 */
@WebServlet(name = "AuthorController", urlPatterns = {"/AuthorController"})
public class AuthorController extends HttpServlet {

    
    private String driver;
    private String url;
    private String username;
    private String password;
    
    @Inject
    private AuthorService authorService;
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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        configDbConnection();
        
        try{
            
            List authors=authorService.getAuthorList();
            
            request.setAttribute("authorList",authors);
            request.setAttribute("endOfList",authors.size());
            
            RequestDispatcher view=request.getRequestDispatcher("/authorList.jsp");
            view.forward(request,response);
        }catch(Exception e){
            System.out.println("Fatal Error");
            e.printStackTrace();
        }
    
    }

    private void configDbConnection(){
       authorService.getAuthorDAO().initDAO(driver, url, username, password);
    }
    
    @Override
    public void init() throws ServletException{
        driver=getServletContext().getInitParameter("db.driver.class");
        url=getServletContext().getInitParameter("db.url");
        username=getServletContext().getInitParameter("db.username");
        password=getServletContext().getInitParameter("db.password");
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
        processRequest(request, response);
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
        processRequest(request, response);
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
