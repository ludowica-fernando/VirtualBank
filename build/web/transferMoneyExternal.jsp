<%-- 
    Document   : transferMoneyExternal
    Created on : 02-May-2017, 16:04:24
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

    <body background="images/bank1.jpg">
        <%@ include file="toolbar.jsp" %>
        <%@ include file="navigation.jsp" %>
        <div class="form">
            <div class="formmodal-container">
                <h2> Send Money to External Account</h2><br><br>
                
                <form method="POST" action="PayExternalServlet">
                    <label> Amount to send: </label>
                    <input type="text" name="amountSend"/><br/><br/>

                   <label> Bank of the Receiver:</label>
                    <input type="text" name="externalBank"/><br/><br/>

                   <label> Bank Branch of the Receiver:</label>
                    <input type="text" name="branchBank"/><br/><br/>

                   <label> Send to: (Account number of the receiver)</label>
                    <input type="text" name="acnoTo"/><br/><br/>

                   <label> Send from: (Account number of the sender)</label>
                    <input type="text" name="acnoFrom"/><br/><br/>

                    <input type="submit" value="Send" name="button">
                </form>
            </div>
        </div>
        <footer>
            Copyright © 2017 StarTrust Bank. All rights reserved.
        </footer>
    </div>
</body>
</html>
