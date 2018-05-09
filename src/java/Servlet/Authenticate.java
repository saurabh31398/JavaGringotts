/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;


/**
 *
 * @author Saurabh-HP
 */
public class Authenticate extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String uname, pass;
            int accountNumber;
            boolean correctCredentials = false;
            uname = request.getParameter("unm");
            pass = request.getParameter("pass");
            String fileName = "H:\\Projects\\Database\\0Usernames.txt";
            File fname = new File(fileName);
            FileReader fRead = new FileReader(fname);
            BufferedReader bRead = new BufferedReader(fRead);
            String line;
            while((line = bRead.readLine())!=null)
            {
                String[] words = line.split("[;]");
                if( words[0].equals(uname)&& words[1].equals(pass))
                {
                    correctCredentials = true;
                    break;
                }                
            }
            if(!correctCredentials)
            {
                response.sendRedirect("LogInFailed.jsp");
            }
            if(correctCredentials)
            {
                String rme = request.getParameter("rme");
                if(rme != null)
                {
                    Cookie c = new Cookie("un",uname);
                    c.setMaxAge(60*5);
                    response.addCookie(c);
                }
                //creating a session for each user logging in
                HttpSession session = request.getSession(true);
                session.setAttribute("userIsLoggedIn",uname);
                
                //redirect to UserHome.jsp
                response.sendRedirect("UserHome.jsp");
                
            }
            
        }
    

  @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() 
    {
        return "Short description";
    }


}
