<%-- 
    Document   : cardHomePage
    Created on : 28-Apr-2017, 15:25:53
    Author     : Ludowica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/theme.css">
        <title>StarTrust Bank of Ceylon | Sri Lanka</title>
    </head>
    <body>
        <header>
            <h1><center>Star Trust Bank</center></h1>
            <h1><center>Card Center Home Page</center></h1>
            <img src="images/logo.jpg" alt="StarTrust Bank Logo" style="width:200px;height:114px;">
            <div class="containerd">
                <a href="cardHomePage.jsp">Home</a>  
                <a href="approveCreditCard.jsp">Approve Credit Card Requests</a>
                <a href="CreditCardMessage.jsp">Send messages</a>
                <a href="SignoutServlet">Sign Out</a>
            </div>
        </header>
        <%@ include file="navigation.jsp" %>

        <footer>
            Copyright © 2017 StarTrust Bank. All rights reserved.
        </footer>
    </body>
</html>
