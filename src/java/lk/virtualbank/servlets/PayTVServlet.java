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
import lk.virtualbank.beans.ApproveCreditCard;
import lk.virtualbank.beans.Transactions;

/**
 *
 * @author Ludowica
 */
@WebServlet(name = "PayTVServlet", urlPatterns = {"/PayTVServlet"})
public class PayTVServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tvtype = request.getParameter("tvtype");
        double amount = Double.parseDouble(request.getParameter("amount"));
        String contractno = request.getParameter("contractno");
        String paymentType = request.getParameter("paymentType");
        String name = request.getParameter("name");
        String button = request.getParameter("button");
        String idNo = request.getParameter("idNo");

        String nic = (String)request.getSession().getAttribute("username");
        
        //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.now();
        String date = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(localDate);
        Transactions pay = new Transactions();
        ApproveCreditCard ac = new ApproveCreditCard();
        
        

        if (paymentType.equals("acno")) {
            if (pay.checkPayer(idNo)) {
                if (pay.checkBalance(idNo)) {
                    if (pay.addTV(tvtype, amount, idNo, date, nic)) {
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
                if (pay.addTV(tvtype, amount, idNo, date, nic)) {
                    response.sendRedirect("paymentSuccessful.jsp");
                } else {
                    response.sendRedirect("paymentUnsuccessful.jsp");
                }

            }
        }

    }

}
