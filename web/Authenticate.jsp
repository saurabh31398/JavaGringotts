
<jsp:useBean id="us" scope="page" class="bank.User" />
<jsp:setProperty name="us" property="*"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <h1>Hello <%= us.getNm() %></h1>
         <h1>Hello <%= us.getPass() %></h1>
    </body>
</html>
