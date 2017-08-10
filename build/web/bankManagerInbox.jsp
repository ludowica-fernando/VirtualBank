<%-- 
    Document   : bankManagerInbox
    Created on : 29-May-2017, 10:33:12
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
                               sql="select * from MESSAGES where RECEIVER = 'bankmanager'"/>
                    <table>
                        <tr>
                            <th>Sender</th>
                            <th>Message</th>
                            <th>Receiver</th>
                        </tr>
                        <c:forEach var="user" items="${u.rows}">
                            <tr>
                                <td><c:out value="${user.sender}"/></td>
                                <td><c:out value="${user.message}"/></td>
                                <td><c:out value="${user.receiver}"/></td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>        
    </body>
</html>
