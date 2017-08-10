/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.virtualbank.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lk.virtualbank.beans.FundTransfers;

/**
 *
 * @author Ludowica
 */
@WebServlet(name = "MoneyManagementServlet", urlPatterns = {"/MoneyManagementServlet"})
public class FundTransferServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acnoTo = request.getParameter("acnoTo");
        String acnoFrom = request.getParameter("acnoFrom");
        double amountSend = Double.parseDouble(request.getParameter("amountSend"));

        LocalDate localDate = LocalDate.now();
        String date = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(localDate);
        FundTransfers reg = new FundTransfers();

        if (reg.checkSender(acnoFrom)) {
            if (reg.checkReceiver(acnoTo)) {
                if (reg.checkBalance(acnoFrom)) {
                    if (reg.doTransfer(acnoTo, amountSend)) {
                        if (reg.updateAc(acnoFrom, amountSend)) {
                            if (reg.updateTransfer(acnoFrom, acnoTo, amountSend, date)) {
                                response.sendRedirect("transactionComplete.jsp");
                            } else {
                                response.sendRedirect("transfermoney.jsp?retry=1");
                            }
                        }
                    }
                }else{
                    response.sendRedirect("invalidBalance.jsp");
                }

            } else {
                response.sendRedirect("receiverNotExist.jsp");
            }

        } else {
            response.sendRedirect("senderNotExist.jsp");
        }

    }

}
