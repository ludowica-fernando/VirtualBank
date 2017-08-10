<%-- 
    Document   : registersuccess
    Created on : 07-Apr-2017, 12:07:06
    Author     : Ludowica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/theme.css">
        <title>Operation successful</title>
    </head>
    <body>
        
        <%@ include file="navigation.jsp" %>
        <br/>
        <div class="form">
            <div class="formmodal-container">
                <center>
                    <h4>Your application for a savings account has being forwarded to our bank.</h4><br/>
                    <h4>Your Account Number is:</h4>
                    <c:out value="${requestScope.array[0]}" /><br/><br/>
                    <a href="dashboard.jsp">Click here to go back</a>
                    <br/>
                </center>
            </div></div>
        <footer>
            Copyright © 2017 StarTrust Bank. All rights reserved.
        </footer>
    </body>
</html>
