

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
       UserHome.process();
      
        %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <h2><%=UserHome.getAccountNumber()%></h2>
        <form method="post" action="TransferProcess.jsp">
            <h2>Galleons to be transfered : <input type="number" name="amount" placeholder="Amount.."></h2>
            <h2>Transfer To : <input type="number" name="accountNumberTo" placeholder="Account Number.."></h2>
            <h2><input type="submit" value="Submit" ></h2>

        </form>
    </body>
</html>
