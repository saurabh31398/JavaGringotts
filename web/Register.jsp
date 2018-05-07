
<jsp:useBean id="SignIn" scope="page" class="bank.SignIn"/>
<jsp:setProperty name="SignIn" property="*"/>
<%SignIn.process();%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
        
        <link rel='stylesheet' href='index.css'>
        <link rel="stylesheet" href="bootstrap-reboot.min.css">
        <link href="https://fonts.googleapis.com/css?family=Shojumaru" rel="stylesheet"> 
    </head>
    <body background="harryPotter.jpg">
    <center>
        <div style="margin: 100px">
        <h2 align="center" > <%= SignIn.getResult()%></h2>
        <h2> </h2>
        <a href="index.jsp">Home</a>
        <br><a href="SignIn.jsp">Sign In</a>
        </div>
    </center>
         
    </body>
</html>
