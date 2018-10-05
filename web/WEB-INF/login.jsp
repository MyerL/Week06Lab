<%-- 
    Document   : login
    Created on : Sep 28, 2018, 3:39:08 PM
    Author     : 738409
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" action="login">
        
        <h1>Remember Me Login Page</h1>
        <br>
        Username: <input type="text" name="u" value="${u}"></input>
        <br>
        Password: <input type="password" name="p" value="${p}"></input>
        <br>
        <input type="checkbox" name="checkers" ${check}> Remember Me <br>
        <input type="submit" value="Login" >
        <br>
        
        </form>
        ${error}
    </body>
</html>
