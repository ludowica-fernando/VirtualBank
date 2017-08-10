<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/theme.css">
        <title>StarTrust Bank Ceylon | Sri Lanka</title>
    </head>
    <body background="images/login_page.jpg">
        <header>
            <center>
                <h1>Welcome To Star Trust Online Banking!</h1>
            </center>
        </header>
        <%@ include file="navigation.jsp" %>
        <div class="form">
            <div class="formmodal-container">
                <h1>Login to Your Account</h1><br>
                <form method="POST" action="RegisterServlet">
                    <label>First Name: </label>
                    <input type="text" name="fname" /><br/><br/>

                    <label>Last Name: </label>
                    <input type="text" name="lname" /><br/><br/>

                    <label>Address:</label>
                    <input type="text" name="address" /><br/><br/>

                    <label>Gender:</label>
                    <input type="radio" name="gender" value="male" />  Male 
                    <input type="radio" name="gender" value="female" />  Female<br/><br/>

                    <label>Telephone:</label>
                    <input type="text" name="telephone"><br/><br/>

                    <label>Email:</label>
                    <input type="email" name="email"><br/><br/>

                    <label>NIC No:</label>
                    <input type="text" name="nic"><br/><br/>

                    <label>Account number:</label>
                    <input type="text" name="acno"><br/><br/>

<!--                    <input type="hidden" value="${requestScope.password}" name="password">-->

                    <input type="submit" name="button" value="Register"><br/>
                </form>
            </div>
        </div>
        <br/><br/>
    <footer>
        Copyright © 2017 StarTrust Bank. All rights reserved.
    </footer>
</body>
</html>