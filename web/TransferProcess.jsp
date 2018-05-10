
<jsp:useBean id="Transfer" scope="page" class="bank.Transfer"/>
<jsp:setProperty name="Transfer" property="*"></jsp:setProperty>

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
       String x = UserHome.getAccountNumber();
       Transfer.process();
       
        %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
            <% if(Transfer.getResult() == true)
                out.println("true");
                else
                out.println("false");
            %>
        <h1>Hello World!</h1>
    </body>
</html>
