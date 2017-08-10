
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/theme.css">
        <title>StarTrust Bank Ceylon | Sri Lanka</title>
    </head>
    <body  background="images/bank1.jpg">
        <%@ include file="toolbar.jsp" %>
        <%@ include file="navigation.jsp" %>
        <div class="form">
            <div class="formmodal-container">
                <form method="POST" action="PayExternalServlet">
                    <h1>Enter the following details:</h1><br>
                    <br/>
                    <label>Transfer Type</label><br/>
                    <input type="radio" required name="transfertype" value="mobileCash" />Mobile Cash ( + 100 ) <br/>
                    <input type="radio" required name="transfertype" value="externalAc" />External Account ( + 200 ) <br/><br/>

                    <label>To</label>
                    <input type="text" name="to"/><br/><br/>
                    
                    <label>Amount</label>
                    <input type="text" name="amount"/><br/><br/>

                    <label>Senders Account Number</label>
                    <input type="text" name="acno"/><br/><br/>

                    <input type="submit" name="button" value="Pay"><br/>
                </form>
            </div></div>
        <footer>
            Copyright © 2017 StarTrust Bank. All rights reserved.
        </footer>
    </body>
</html>