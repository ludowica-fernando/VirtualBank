<%-- 
    Document   : choosePayBills
    Created on : 29-Apr-2017, 22:26:45
    Author     : Ludowica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/theme.css">
        <title>StarTrust Bank of Ceylon | Sri Lanka</title>
    </head>
    <body background="images/bank1.jpg">
        <div class="container">
            <%@ include file="toolbar.jsp" %>
            <%@ include file="navigation.jsp" %>
            <article>
                <div class="form">        
                    <div class="formmodal-container">
                        <h1>Please Choose Billing Type</h1><br/>
                        <form action="ChoosePayBillsServlet" method="GET">

                            <table>                        
                                <tbody>
                                    <tr>
                                        <td>
                                            <input type="submit" name="button" value="Pay Tv Bill"/>
                                        </td>
                                        <td>
                                            <input type="submit" name="button" value="Pay Electricity/Water Bill"/>                                    
                                        </td>
                                        <td>
                                            <input type="submit" name="button" value="Pay Insurance Bill"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <input type="submit" name="button" value="Pay Internet Bill"/>
                                        </td>
                                        <td>
                                            <input type="submit" name="button" value="Pay Telephone Bill"/>
                                        </td>
                                        <td>
                                            <input type="submit" name="button" value="External Cash Transfer"/>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </form>
                    </div></div>
            </article>
        </div>
    </center>
    <footer>
        Copyright © 2017 StarTrust Bank. All rights reserved.
    </footer>
</body>
</html>
