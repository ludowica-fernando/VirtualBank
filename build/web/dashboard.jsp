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

    <body background="images/background.jpg">
        <%@ include file="toolbar.jsp" %>
        <%@ include file="navigation.jsp" %>
        <div class="container">
            <div class="form">
                <div class="formmodal-container">
                    <h1>Savings Account Details</h1>
                    <sql:setDataSource
                        var="dbcon"
                        driver="org.apache.derby.jdbc.ClientDriver"
                        url="jdbc:derby://localhost:1527/dbstartrust"
                        user="ludowica"
                        password="ludowica"/>
                    <br/>
                    <sql:query var="u"
                               dataSource="${dbcon}"
                               sql="select * from APPROVEDSAVINGSACC where nic= '${loginArray[0]}'"/>
                    <table>
                        <tr>
                            <th>Name</th>
                            <th>NIC</th>
                            <th>Account No.</th>
                            <th>Balance</th>
                        </tr>
                        <c:forEach var="user" items="${u.rows}">
                            <tr>
                                <td><c:out value="${user.fname}"/></td>
                                <td><c:out value="${user.nic}"/></td>
                                <td><c:out value="${user.acno}"/></td>
                                <td><c:out value="${user.balance}"/></td>
                            </tr>
                        </c:forEach>
                    </table>

                    <br/><br/><br/>
                    <h1>Fixed-Deposit Account Details</h1>
                    <br/>
                    <sql:query var="u"
                               dataSource="${dbcon}"
                               sql="select * from APPROVEDFIXEDACC where nic= '${loginArray[0]}'"/>
                    <table>
                        <tr>
                            <th>Name</th>
                            <th>NIC</th>
                            <th>Term</th>
                            <th>Amount</th>
                        </tr>
                        <c:forEach var="user" items="${u.rows}">
                            <tr>
                                <td><c:out value="${user.fname}"/></td>
                                <td><c:out value="${user.nic}"/></td>
                                <td><c:out value="${user.term}"/></td>
                                <td><c:out value="${user.amount}"/></td>
                            </tr>
                        </c:forEach>
                    </table>

                    <br/><br/><br/>
                    <h1>Recent Transactions</h1>
                    <sql:setDataSource
                        var="dbcon"
                        driver="org.apache.derby.jdbc.ClientDriver"
                        url="jdbc:derby://localhost:1527/dbstartrust"
                        user="ludowica"
                        password="ludowica"/>
                    <br/>
                    <sql:query var="u"
                               dataSource="${dbcon}"
                               sql="select * from transactions where nic = '${loginArray[0]}'"/>
                    <table>
                        <tr>
                            <th>Type</th>
                            <th>Amount</th>
                            <th>Account No.</th>
                            <th>Date</th>
                        </tr>
                        <c:forEach var="user" items="${u.rows}">
                            <tr>
                                <td><c:out value="${user.type}"/></td>
                                <td><c:out value="${user.amount}"/></td>
                                <td><c:out value="${user.acno}"/></td>
                                <td><c:out value="${user.date}"/></td>
                            </tr>
                        </c:forEach>
                    </table>
                    <br/><br/>
                </div>
            </div></div>
        <footer>
            Copyright © 2017 StarTrust Bank. All rights reserved.
        </footer>
    </body>
</html>