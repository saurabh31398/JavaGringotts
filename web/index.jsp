


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GRINGOTTS BANK</title>
        <link rel='stylesheet' href='index.css'>
        <link rel="stylesheet" href="bootstrap-reboot.min.css">
        <link href="https://fonts.googleapis.com/css?family=Shojumaru" rel="stylesheet"> 
    </head>
    <body background="harryPotter.jpg" height='100%'>
        <h1 align="center"> GRINGOTTS &nbsp; BANK </h1>
        <h2 align="center">Welcome to Gringotts A bank for Wizards & Witches </h2>
        <div >
        <form method="post" action="Authenticate.jsp" id = "logIn" >
            <h3> LOG IN </h3>
            <h3 align="left" padding="50px" ><input type="text" name="unm" class="formInput" placeholder='UserName..'style="width: 400px"/></h3>
            <h3 align="left" padding="50px" ><input type="password" name="pass" class="formInput" placeholder='password..' style="width: 400px"/></h3>
            <p ><input type="submit" value="Submit"padding='25px' style="width: 400px"></p> 
            <a href="SignIn.jsp">Not Registered ! So Sign In</a>
        </form>
  
        </div>
    </body>
</html>
