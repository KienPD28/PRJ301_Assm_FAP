<%-- 
    Document   : login
    Created on : Mar 7, 2024, 9:35:23 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link rel="stylesheet" href="./css/login.css"/>
</head>
<body>
    <div class="login-container">
        <h2>Login</h2>
        <form class="login-form" action="login" method="POST">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username"/>
            <br/>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password"/>
            <br/>
            <input type="submit" value="Login"/>
        </form>
    </div>
</body>
</html>

