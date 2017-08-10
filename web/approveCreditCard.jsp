<%-- 
    Document   : approveCreditCard
    Created on : 28-May-2017, 22:46:39
    Author     : Ludowica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/theme.css">
        <title>StarTrust Bank of Ceylon | Sri Lanka</title>
    </head>
    <body>
        <header>
            <h1><center>Star Trust Bank</center></h1>
            <h1><center>Card Center Home Page</center></h1>
            <img src="images/logo.jpg" alt="StarTrust Bank Logo" style="width:200px;height:114px;">
            <div class="containerd">
                <a href="cardHomePage.jsp">Home</a>  
                <a href="approveCreditCard.jsp">Approve Credit Card Requests</a>
                <a href="CreditCardMessage.jsp">Send messages</a>
                <a href="SignoutServlet">Sign Out</a>
            </div>
        </header>
        <%@ include file="navigation.jsp" %>
        <div class="container">
            <div class="form">
                <div class="table-container">
                    <h1>New Credit Card Request Details</h1>
                    <sql:setDataSource
                        var="dbcon"
                        driver="org.apache.derby.jdbc.ClientDriver"
                        url="jdbc:derby://localhost:1527/dbstartrust"
                        user="ludowica"
                        password="ludowica"/>
                    <br/>
                    <sql:query var="u"
                               dataSource="${dbcon}"
                               sql="select * from PENDINGCREDITCARD"/>
                    <table border="1">
                        <tr>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>NIC</th>
                            <th>Limit</th>
                            <th>Account No.</th>
                            <th>Credit Card No.</th>
                        </tr>
                        <c:forEach var="user" items="${u.rows}">
                            <tr>
                                <td><c:out value="${user.fname}"/></td>
                                <td><c:out value="${user.lname}"/></td>
                                <td><c:out value="${user.nic}"/></td>
                                <td><c:out value="${user.limit}"/></td>
                                <td><c:out value="${user.acno}"/></td>
                                <td><c:out value="${user.creditcardno}"/></td>
                            </tr>
                        </c:forEach>
                    </table>
                    <br/><br/><br/>
                    <form action="ApproveCreditCardServlet" method="POST">
                        <h2>Enter the credit card number of the request to approve: </h2><br/>
                        <input type="input" name="creditcardno" placeholder="Enter credit card number..."><br/><br/>
                        <input type="submit" name="button" value="Approve"><br/><br/>
                    </form>
                </div>  
            </div>
        </div>
    </body>
</html>
