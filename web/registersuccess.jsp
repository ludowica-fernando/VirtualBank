<%-- 
    Document   : registersuccess
    Created on : 07-Apr-2017, 12:07:06
    Author     : Ludowica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/theme.css">
        <title>Registered Successfully!!</title>
    </head>
    <body>
        <br/>
        <div class="form">
            <div class="formmodal-container">
                <center>
                    <h4>You have being registered into the system successfully!</h4><br/>
                    <h4>Your Username is:</h4>
                    <c:out value="${requestScope.array[0]}" /><br/><br/>
                    <h4>Your Password is:</h4>
                    <c:out value="${requestScope.array[1]}" /><br/>
                    <br/><br/>
                    <a href="index.jsp">Click here to go back</a>
                    <br/>
                </center>
            </div></div>
        <footer>
            Copyright © 2017 StarTrust Bank. All rights reserved.
        </footer>
    </body>
</html>