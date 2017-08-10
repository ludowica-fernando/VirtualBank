<%-- 
    Document   : registersuccess
    Created on : 07-Apr-2017, 12:07:06
    Author     : Ludowica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/theme.css">
        <title>Already Exists</title>
    </head>
    <body background="images/wallpapers.jpg">
        <div class="container">
            <header>
                <h1><center>
                        <img src="images/logo.jpg" alt="StarTrust Bank Logo" height="70" width="100">
                        StarTrust Bank
                    </center></h1>
            </header>
            
            <%@ include file="navigation.jsp" %>
            <br/>
            <center>
                <h4>An online portal for this account has already being created.</h4><br/>
                <h4>Please check your details</h4><br/><br/>
                <a href="index.jsp">Click here to go back</a>
                <br/>
            </center>

            <footer>
                Copyright © 2017 StarTrust Bank. All rights reserved.
            </footer>
        </div>
    </body>
</html>
