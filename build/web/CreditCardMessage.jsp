<%-- 
    Document   : CreditCardMessage
    Created on : 31-May-2017, 07:38:48
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
        <header>
            <h1><center>Star Trust Bank</center></h1>
            <h1><center>Card Center Home Page</center></h1>
            <img src="images/logo.jpg" alt="StarTrust Bank Logo" style="width:200px;height:114px;">
            <div class="containerd">
                <a href="cardHomePage.jsp">Home</a>  
                <a href="approveCreditCard.jsp">Approve Credit Card Requests</a>
                <a href="BankManagerMessage.jsp">Send messages</a>
                <a href="SignoutServlet">Sign Out</a>
            </div>
        </header>
        <%@ include file="navigation.jsp" %>
        <br/>
        <form action="BankMessageServlet" method="POST">
            <fieldset>
                <legend><h3>Send us a message</h3></legend>

                <br/>
                <h5>Sender:</h5><br/>
                <input type="radio" name="sender" value="creditcardmanager" />Credit Card Centre Manager<br/>                

                <h5>Message:</h5>
                <textarea name="message" cols="44" rows="6"></textarea>
                <br/><br/>

                <h5>Send to:</h5><br/>
                <input type="radio" name="receiver" value="customer" />Customer<br/>
                <input type="radio" name="receiver" value="bankmanager" />Bank Manager<br/><br/>

                <h5>If customer, enter Customer's name</h5>
                <input type="text" name="acno"><br/><br/>

                <input type="submit" name="button" value="Send">

            </fieldset>
        </form>
    </div>
    <footer>
        Copyright © 2017 StarTrust Bank. All rights reserved.
    </footer>
</body>
</html>
