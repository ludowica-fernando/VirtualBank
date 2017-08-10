<%-- 
    Document   : transfermoney
    Created on : 18-Apr-2017, 10:28:24
    Author     : Ludowica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/theme.css">
        <title>StarTrust Bank Ceylon | Sri Lanka</title>
    </head>

    <body>
        <div class="container">
            <%@ include file="toolbar.jsp" %>
            <%@ include file="navigation.jsp" %>

            <article>
                <form method="POST" action="MoneyManagementServlet">

                    <label> Amount to send:</label>
                    <input type="text" name="amountSend"/><br/><br/>

                    <label>Send to: (A/C)</label>
                    <input type="text" name="acnoTo"/><br/><br/>

                    <label>Send from: (A/C)</label>
                    <input type="text" name="acnoFrom"/><br/><br/>

                    <input type="submit" value="Send" name="button">

                </form>
            </article>
            <footer>
                Copyright © 2017 StarTrust Bank. All rights reserved.
            </footer>
        </div>
    </body>
</html>
