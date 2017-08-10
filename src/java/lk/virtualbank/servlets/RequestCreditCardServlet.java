/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.virtualbank.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lk.virtualbank.beans.PendingCreditCard;

/**
 *
 * @author Ludowica
 */
@WebServlet(name = "RequestCreditCardServlet", urlPatterns = {"/RequestCreditCardServlet"})
public class RequestCreditCardServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String nic = request.getParameter("nic");
        String acno = request.getParameter("acno");
        double limit = Double.parseDouble(request.getParameter("limit"));
        String button = request.getParameter("button");
        String creditcardno = "";
        String creditNO = "";

        PendingCreditCard m = new PendingCreditCard();

        if (button.equals("Request")) {
            if (m.checkAccount(acno)) {
                if (((creditNO = m.requestCreditCard(fname, lname, nic, limit, acno, creditcardno))) != null) {
                    String[] array = new String[5];
                    array[0] = creditNO;
                    request.setAttribute("array", array);
                    request.getRequestDispatcher("requestCreditCardSuccess.jsp").forward(request, response);
                } else {
                    response.sendRedirect("requestCreditCard.jsp?retry=1");
                }
            }
            else{
                response.sendRedirect("accountNotExist.jsp");
            }

        } else {
            response.sendRedirect("dashboard.jsp?retry=1"); //redirected to this page if an error occurs.
        }
    }

}
