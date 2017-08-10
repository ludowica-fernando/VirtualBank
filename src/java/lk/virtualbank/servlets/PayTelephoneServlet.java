/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.virtualbank.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lk.virtualbank.beans.ApproveCreditCard;
import lk.virtualbank.beans.Transactions;

/**
 *
 * @author Ludowica
 */
@WebServlet(name = "PayTelephoneServlet", urlPatterns = {"/PayTelephoneServlet"})
public class PayTelephoneServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String telephonetype = request.getParameter("telephonetype");
        double amount = Double.parseDouble(request.getParameter("amount"));
        String telephone = request.getParameter("telephone");
        String paymentType = request.getParameter("paymentType");
        String idNo = request.getParameter("idNo");
        String name = request.getParameter("name");
        String nic = request.getParameter("nic");

        LocalDate localDate = LocalDate.now();
        String date = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(localDate);
        Transactions pay = new Transactions();
        ApproveCreditCard ac = new ApproveCreditCard();

        if (paymentType.equals("acno")) {
            if (pay.checkPayer(idNo)) {
                if (pay.checkBalance(idNo)) {
                    if (pay.addTelephone(telephonetype, amount, idNo, date, nic)) {
                        if (pay.updateBalance(amount, idNo)) {
                            response.sendRedirect("paymentSuccessful.jsp");
                        } else {
                            response.sendRedirect("paymentUnsuccessful.jsp");
                        }
                    } else {
                        response.sendRedirect("index.jsp");
                    }
                } else {
                    response.sendRedirect("invalidBalance.jsp");
                }

            } else {
                response.sendRedirect("senderNotExist.jsp");
            }
        } else if (paymentType.equals("creditcardno")) {
            if (ac.updateCreditCard(amount, idNo)) {
                if (pay.addTelephone(telephonetype, amount, idNo, date, nic)) {
                    response.sendRedirect("paymentSuccessful.jsp");
                } else {
                    response.sendRedirect("paymentUnsuccessful.jsp");
                }

            }
        }
    }

}
