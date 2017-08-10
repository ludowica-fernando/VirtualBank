
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
            <a href="dashboard.jsp">Home</a>
            <a href="choosePayBills.jsp">Make Payments</a>
            <div class="dropdown">
                <button class="dropbtn">Open Accounts</button>
                <div class="dropdown-content">
                    <a href="regSavings.jsp">Savings Account</a>
                    <a href="regFixedDeposit.jsp">Fixed-Deposit Account</a>
                </div>
            </div>

            <div class="dropdown">
                <button class="dropbtn">View</button>
                <div class="dropdown-content">
                    <a href="customerInbox.jsp">Inbox</a>
                </div>
            </div>
            <a href="transfermoney.jsp">Transfer Money</a>
            <a href="requestCreditCard.jsp">Request Credit Card</a>
            <a href="createStandingOrder.jsp">Create a standing order</a>
            <a href="SignoutServlet">Sign Out</a>
        </div>   
    <c:set var="sessionID" scope="session" value="${sessionScope.loginArray[0]}"/>
    <c:if test="${sessionID == null}"> 
        <c:redirect url="index.jsp"/>
    </c:if>


</body>
</html>
