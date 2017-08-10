

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
        <div class="container">
            <%@ include file="toolbar.jsp" %>
            <%@ include file="navigation.jsp" %>
            <article>
                <form method="POST" action="RegisterSavingsServlet">
                    <legend><h3>Please fill in your details</h3></legend><br/>

                    <label>First Name:</label>
                    <input type="text" name="fname" /><br/><br/>

                    <label>Last Name: </label>
                    <input type="text" name="lname" /><br/><br/>

                    <label>Gender: </label>
                    <input type="radio" name="gender" value="male" />  Male 
                    <input type="radio" name="gender" value="female" />  Female<br><br>

                    <label>Telephone:</label>
                    <input type="text" name="telephone"><br/><br/>

                    <label>NIC:</label>
                    <input type="text" name="nic"><br/><br/>

                    <label>Initial Installment Amount:</label>
                    <input type="text" name="amount"><br/><br/>
                    
                    <label>Existing Account Number:</label>
                    <input type="text" name="acnoFrom"><br/><br/>
                    
                    <br/><br/><input type="submit" name="button" value="Submit Savings">
                </form>
            </article>
        </div>
        <footer>
            Copyright © 2017 StarTrust Bank. All rights reserved.
        </footer>
    </body>
</html>
