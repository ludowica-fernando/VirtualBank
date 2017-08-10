<%-- 
    Document   : bankToolbar
    Created on : 30-May-2017, 22:19:23
    Author     : Ludowica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <header>
            <h1><center>
                    StarTrust Bank
                </center></h1>
        </header>
        <div class="containerd">
            <a href="bankHomePage.jsp">Home</a>
            <div class="dropdown">
                <button class="dropbtn">Approve</button>
                <div class="dropdown-content">
                    <a href="approveSavingsAcc.jsp">Savings Account</a>
                    <a href="approveFixedAcc.jsp">Fixed-Deposit Account</a>
                    <a href="approveCustomers.jsp">Online Portals</a>
                    <a href="updateInterestRates.jsp">Interest Rates</a>
                </div>
            </div>
            <a href="BankManagerMessage.jsp">Send messages</a>
            <a href="bankManagerInbox.jsp">Message Inbox</a>
            <a href="SignoutServlet">Sign Out</a>
        </div>   
    <c:set var="sessionID" scope="session" value="${sessionScope.loginArray[0]}"/>
    <c:if test="${sessionID == null}"> 
        <c:redirect url="index.jsp"/>
    </c:if>
</body>
</html>

