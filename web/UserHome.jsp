<%@page import="javax.servlet.http.*" %>
<%@page import="java.io.PrintWriter"%>
<%@page session="false" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="UserHome" scope="page" class="bank.UserHome"/>
<jsp:setProperty name="UserHome" property="*"></jsp:setProperty>
<%  javax.servlet.RequestDispatcher rd = request.getRequestDispatcher("SessionTicketing");
        rd.include(request, response);
        HttpSession session1 = request.getSession(false);
        String userInfo = "error";
        try
        {
            userInfo = session1.getAttribute("userIsLoggedIn").toString();
        }
        catch(Exception ex)
        {}
        if("error".equals(userInfo))
        {
            response.sendRedirect("index.jsp");
        }
        
       UserHome.setUserInfo(userInfo);
        %>

<%UserHome.process();%>

<!DOCTYPE html>
<%@ page import="Servlet.RequestDispatcher"%> 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <%= userInfo%>
      
          <%UserHome.setUserInfo(userInfo);%>
        <h2><%=UserHome.getName()%></h2>
        
        <h1>Hello World</h1>
        <h2>w : <%=UserHome.getName()%></h2>
        
    </body>
</html>
