<%-- 
    Document   : updateInterestRates
    Created on : 28-Apr-2017, 15:56:43
    Author     : Ludowica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/theme.css">
        <title>updateInterestRates</title>
    </head>
    <body background="images/bank1.jpg">

        <%@ include file="bankToolbar.jsp" %>
        <%@ include file="navigation.jsp" %>
        <div class="form">
            <div class="formmodal-container">
                <h2>Enter the following details:</h2><br>
                <form method="POST" action="UpdateInterestServlet">
                    <label>Select type:</label><br>
                    <input type="radio" name="interesttype" value="savings"/>Savings Account<BR>
                    <input type="radio" name="interesttype" value="fixed"/>Fixed Deposit Account<br/><br/>

                    <label>Select period:</label>
                    <select name="newPeriod">
                        <option value="1">12 months</option>
                        <option value="2">24 months</option>
                        <option value="3">36 months</option>
                        <option value="4">48 months</option>
                        <option value="5">60 months</option>
                    </select><br/><br/>

                    <label>Enter new rate:</label>
                    <input type="text" name="newrate"/><br/><br/>

                    <input type="submit" name="update" value="Update"/>
                    
                </form>
            </div>
        </div>
    </body>
</html>
