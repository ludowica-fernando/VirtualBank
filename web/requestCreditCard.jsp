<%-- 
    Document   : requestCreditCard
    Created on : 08-May-2017, 09:47:43
    Author     : Ludowica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/theme.css">
        <title>StarTrust Bank Ceylon | Sri Lanka</title>
    </head>
    <body>
        <%@ include file="toolbar.jsp" %>
        <%@ include file="navigation.jsp" %>
        <div class="form">
            <form method="POST" action="RequestCreditCardServlet">
                <h2>Request Credit Card Form </h2><br><br>
                <label>First Name: </label>
                <input type="text" name="fname" /><br/><br/>

                <label>Last Name: </label>
                <input type="text" name="lname" /><br/><br/>

                <label>NIC No:</label>
                <input type="text" name="nic"><br/><br/>

                <label>Account number:</label>
                <input type="text" name="acno"><br/><br/>

                <label>Credit Limit:</label>
                <input type="text" name="limit"><br/><br/>

                <input type="submit" name="button" value="Request"><br/>
            </form>
        </div>
        <br/><br/>

    <footer>
        Copyright © 2017 StarTrust Bank. All rights reserved.
    </footer>
</div>
</body>
</html>