<%@page import="javax.servlet.http.*" %>
<%@page import="java.io.PrintWriter"%>
//<%@page session="false" %>
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
        <link rel='stylesheet' href='index.css'>
        <link rel="stylesheet" href="bootstrap-reboot.min.css">
        <link href="https://fonts.googleapis.com/css?family=Shojumaru" rel="stylesheet"> 
    </head>
    <body background="harryPotter.jpg">
           
                  <h1 align="center"> GRINGOTTS &nbsp; BANK </h1>
        
           <h2 align="center">Welcome to Gringotts A bank for Wizards & Witches </h2>
        <div id="container" >
        <div id="left" style="padding: 20px"> 
            <img src="wizard.png" height="150px" width="150px">
            <h2><%=UserHome.getUsername()%></h2>
        <a href="Transfer.jsp">Wizard&nbsp;Money&nbsp;Transfer</a>
        <p><a href="Passbook.jsp">Request&nbsp;for&nbsp;Statement</a></p>
           </div>
    <center><div id="center"style="width: 60%; text-align: left">
            <h2>NAME : <%=UserHome.getName()%></h2>
            <h2>USERNAME : <%=UserHome.getUsername()%></h2>
            <h2>ACCOUNT NUMBER : <%=UserHome.getAccountNumber()%></h2>
            <h2>ACCOUNT BALANCE : <%=UserHome.getAccountBalance()%></h2>
            <h2>CUSTOMER TYPE : <%=UserHome.getCustomerType()%></h2>

<div id="right">
    <a href="Logout.jsp">Sign&nbspOut</a>
</div>
</div>
         
         
    </center></div>
    </body>
</html>
