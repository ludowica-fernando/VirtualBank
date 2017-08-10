<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/logincss.css">
        <title>StarTrust Bank Ceylon | Sri Lanka</title>
    </head>
    <body background="images/login_page.jpg">
        <header>
            <h2>Welcome To Star Trust Online Banking!</h2>
        </header>
        <div class="form">

            <div class="formmodal-container">
                <center> <h3>Login to Your Account</h3></center><br><br>

                <form action="LoginServlet" method="POST">
                    <input type="text" name="username" placeholder="Username">
                    <input type="password" name="password" placeholder="Password"><br>
                    <center>
                        <input type="submit" name="login" class="login loginmodal-submit" value="Login">
                    </center>
                    <c:if test="${!empty param.retry}">
                        <font color="red">
                        Incorrect Username and Password!!
                        </font>
                    </c:if>
                </form>
                <br/>
                <center>
                    <div class="login-help">
                        <a href="register.jsp">Register now if you don't have an account</a>
                    </div>
                </center>

            </div>
        </div>
        <br/><br/>
        <footer>
            Copyright © 2017 StarTrust Bank. All rights reserved.
        </footer>
    </body>
</html>