
package Servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class RequestDispatcher extends HttpServlet {
    


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("SessionTicketing");
        rd.include(request, response);
        HttpSession session = request.getSession(false);
        String userInfo = "error";
        try
        {
            userInfo = session.getAttribute("userIsLoggedIn").toString();
        }
        catch(Exception ex)
        {}
        if("error".equals(userInfo))
        {
            response.sendRedirect("index.jsp");
        }
        
         
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
