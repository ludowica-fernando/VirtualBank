<%-- 
    Document   : contactus
    Created on : 08-Apr-2017, 11:40:58
    Author     : Ludowica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/theme.css">
        <title>Star Trust Bank | Sri Lanka</title>
    </head>
    <body>
        <%@ include file="toolbar.jsp" %>
        <%@ include file="navigation.jsp" %>
        <br/>

        <form action="CustomerMessageServlet" method="POST">
            <fieldset>
                <legend><h3>Send us a message</h3></legend>

                <br/>
                <h5>Account Number:</h5>
                <input type="text" name="sender"><br/><br/>

                <h5>Name:</h5>
                <input type="text" name="name"><br/><br/>

                <h5>Message:</h5>
                <textarea name="message" cols="44" rows="6"></textarea>
                <br/><br/>

                <h5>Send to:</h5><br/>
                <input type="radio" name="receiver" value="bankmanager" />Star Trust Bank Manager<br/>
                <input type="radio" name="receiver" value="cardmanager" />Card Centre Manager<br/><br/>

                <h5>Nic:</h5>
                <input type="text" name="nic"><br/><br/>
                
                <input type="submit" name="button" value="Send">

            </fieldset>
        </form>
    </div>
    <footer>
        Copyright © 2017 StarTrust Bank. All rights reserved.
    </footer>
</body>
</html>
