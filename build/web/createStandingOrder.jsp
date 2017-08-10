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
            <form method="POST" action="StandingOrderServlet">
                <h2>Create Standing Order </h2><br><br>
                <label>A/C No. </label>
                <input type="text" name="acno" /><br/><br/>

                <label>A/C Receiver: </label>
                <input type="text" name="receiver" /><br/><br/>

                <label>Amount:</label>
                <input type="text" name="amount"><br/><br/>

                <label>Type:</label>
                <input type="text" name="type"><br/><br/>               

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