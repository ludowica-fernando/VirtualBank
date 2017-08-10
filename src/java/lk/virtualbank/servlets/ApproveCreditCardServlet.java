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
import lk.virtualbank.beans.ApproveCreditCard;

/**
 *
 * @author Ludowica
 */
@WebServlet(name = "ApproveCreditCardServlet", urlPatterns = {"/ApproveCreditCardServlet"})
public class ApproveCreditCardServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String fname = request.getParameter("fname");
//        String lname = request.getParameter("lname");
//        String nic = request.getParameter("nic");
//        String acno = request.getParameter("acno");
//        double limit = 0.0;
        String creditcardno = request.getParameter("creditcardno");
        String button = request.getParameter("button");

        ApproveCreditCard aC = new ApproveCreditCard();

        if (button.equals("Approve")) {
            if (aC.selectCreditCard(creditcardno)) {
                response.sendRedirect("creditCardApproved.jsp");
            } else {
                response.sendRedirect("creditCardNotApproved.jsp");
            }
        }

    }
}
