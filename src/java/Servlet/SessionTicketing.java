/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Saurabh-HP
 */
public class SessionTicketing extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userInfo = "error";
        HttpSession session = request.getSession(false);
        if(session == null)
        {
            Cookie arr[] = request.getCookies();
            if(arr == null)
            {
                response.sendRedirect("index.jsp");
            }
            else
            {
                for(Cookie c : arr)
                {
                    if(c.getName().equals("un"))
                    {
                        userInfo = c.getValue();
                    }
                }
                if(userInfo.equals("error"))
                {
                    response.sendRedirect("index.jsp");
                }
                else
                {
                    session = request.getSession(true);
                    session.setAttribute("userIsLoggedIn", userInfo);
                }
            }
        }
        
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
