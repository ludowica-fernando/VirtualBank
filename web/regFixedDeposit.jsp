<%-- 
    Document   : regFixedDeposit
    Created on : 04-Apr-2017, 10:30:29
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
                <form method="POST" action="RegisterFixedDepositServlet">
                        <legend><h3>Please fill in your details</h3></legend><br/>

                        <label>First Name: </label>
                        <input type="text" name="fname" /><br/><br/>

                        <label>Last Name: </label>
                        <input type="text" name="lname" /><br/><br/>

                        <label>Address:</label>
                        <input type="text" name="address" /><br/><br/>

                        <label>Gender:</label>
                        <input type="radio" name="gender" value="male" />  Male
                        <input type="radio" name="gender" value="female" />  Female<br/><br/>

                        <label>Telephone:</label>
                        <input type="text" name="telephone"><br/><br/>

                        <label>NIC:</label>
                        <input type="text" name="nic"><br/><br/>

                        <label>Deposit Amount:</label>
                        <input type="text" name="amount"><br/><br/>

                        <label>Term (In months):</label>
                        <select name="term">
                            <option value="12">12 months</option>
                            <option value="24">24 months</option>
                            <option value="36">36 months</option>
                            <option value="48">48 months</option>
                            <option value="60">60 months</option>
                        </select>
                        <br/><br/>
                        <input type="submit" name="submit" value="Register Fixed"/>
                </form>
            </article>
        </div>

    <footer>
        Copyright © 2017 StarTrust Bank. All rights reserved.
    </footer>
</body>
</html>
