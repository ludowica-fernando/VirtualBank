/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.virtualbank.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lk.virtualbank.beans.Transactions;

/**
 *
 * @author Ludowica
 */
@WebServlet(name = "PayExternalServlet", urlPatterns = {"/PayExternalServlet"})
public class PayExternalServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String transfertype = request.getParameter("transfertype");
        double amount = Double.parseDouble(request.getParameter("amount"));
        String acno = request.getParameter("acno");

        String[] loginArray = (String[]) request.getSession().getAttribute("loginArray");
        String nic = loginArray[0];

        if (transfertype.equals("mobileCash")) {
            amount += 100;
        } else if (transfertype.equals("externalAc")) {
            amount += 200;
        }

        Transactions tra = new Transactions();

        if (tra.updateBalance(amount, acno) && tra.addUtility(transfertype, amount, acno, nic)) {
            response.sendRedirect("transactionComplete.jsp");
        }

    }

}
