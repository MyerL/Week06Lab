<%-- 
    Document   : login
    Created on : Oct 19, 2018, 4:34:06 PM
    Author     : 738409
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>

<%-- any content can be specified here e.g.: --%>
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