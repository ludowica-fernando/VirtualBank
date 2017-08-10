<%-- 
    Document   : BankManagerMessage
    Created on : 29-May-2017, 10:34:26
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
        <%@ include file="bankToolbar.jsp" %>
        <%@ include file="navigation.jsp" %>
        <br/>
        <form action="BankMessageServlet" method="POST">
            <fieldset>
                <legend><h3>Send us a message</h3></legend>

                <br/>
                <h5>Sender:</h5><br/>
                <input type="radio" name="sender" value="bankmanager" />Bank Manager<br/>                
                
                <h5>Message:</h5>
                <textarea name="message" cols="44" rows="6"></textarea>
                <br/><br/>

                <h5>Send to:</h5><br/>
                <input type="radio" name="receiver" value="customer" />Customer<br/>
                <input type="radio" name="receiver" value="cardmanager" />Card Centre Manager<br/><br/>

                <h5>If customer, enter Customer's name</h5>
                <input type="text" name="acno"><br/><br/>

                <input type="submit" name="button" value="Send to customer">

            </fieldset>
        </form>
    </div>
    <footer>
        Copyright © 2017 StarTrust Bank. All rights reserved.
    </footer>
</body>
</html>
