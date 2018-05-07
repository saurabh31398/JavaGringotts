

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GRINGOTTS</title>

        <link rel='stylesheet' href='index.css'>
        <link rel="stylesheet" href="bootstrap-reboot.min.css">
        <link href="https://fonts.googleapis.com/css?family=Shojumaru" rel="stylesheet"> 
       
    </head>
    <body background="harryPotter.jpg">
        <h1 align="center"> GRINGOTTS &nbsp; BANK </h1>
        <h2 align="center">Welcome to Gringotts A bank for Wizards & Witches </h2>
        
        <div style="width:35%;" >
            <form method="post" action="Register.jsp" id="SignIn" style="text-align: left;">
                <h3> SIGN IN </h3>
                    <h3><input type="text" name="nam" size="35" placeholder="NAME.."></h3>
                    <h3><input type="text" name="username" size="35" placeholder="USERNAME.."></h3>
                    <h3><input type="number" name="money"  size="35" placeholder="MONEY TO DEPOSIT(Galleons)" style="width: 391px"></h3>
                    <h3><input type="password" name="pass"  size="35" placeholder="PASSWORD"></h3>
             <select id="cus" name ='customer' class="formInput" style="width: 391px">
                <option value='wizard'>Wizard</option>
                <option value='witch'>Witch</option>
                <option value='Student'>Hogwarts Student</option>
            </select>
                    <input type="submit" value="Submit" style="width: 391px">
                    <a href="index.jsp">HOME</a>
            </form>
            
        </div>
        
    </body>
</html>

