<%-- 
    Document   : approveCustomers
    Created on : 10-May-2017, 14:39:28
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
        <%@ include file="bankToolbar.jsp" %>
        <%@ include file="navigation.jsp" %>
        <div class="container">
            <div class="form">
                <div class="table-container">
                    <h1>New Online Portal Registration Details</h1>
                    <sql:setDataSource
                        var="dbcon"
                        driver="org.apache.derby.jdbc.ClientDriver"
                        url="jdbc:derby://localhost:1527/dbstartrust"
                        user="ludowica"
                        password="ludowica"/>
                    <br/>
                    <sql:query var="u"
                               dataSource="${dbcon}"
                               sql="select * from userdetails"/>
                    <table border="1">
                        <tr>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Address</th>
                            <th>Gender</th>
                            <th>Telephone</th>
                            <th>Email</th>
                            <th>NIC</th>
                            <th>Account No.</th>
                        </tr>
                        <c:forEach var="user" items="${u.rows}">
                            <tr>
                                <td><c:out value="${user.fname}"/></td>
                                <td><c:out value="${user.lname}"/></td>
                                <td><c:out value="${user.address}"/></td>
                                <td><c:out value="${user.gender}"/></td>
                                <td><c:out value="${user.telephone}"/></td>
                                <td><c:out value="${user.email}"/></td>
                                <td><c:out value="${user.nic}"/></td>
                                <td><c:out value="${user.acno}"/></td>
                            </tr>
                        </c:forEach>
                    </table>
                    <br/><br/><br/>
                    <form action="ApproveCustomerServlet" method="POST">
                        <h2>Enter the account number of the online portal to approve: </h2><br/>
                        <input type="input" name="acno" placeholder="Enter account number..."><br/><br/>
                        <input type="submit" name="button" value="Approve"><br/><br/>
                    </form>
                    
                </div>  
            </div>
        </div>
    </body>
</html>
