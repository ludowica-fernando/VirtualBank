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
import lk.virtualbank.beans.ApproveCustomers;

/**
 *
 * @author Ludowica
 */
@WebServlet(name = "ApproveCustomerServlet", urlPatterns = {"/ApproveCustomerServlet"})
public class ApproveCustomerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acno = request.getParameter("acno");
        String button = request.getParameter("button");


        ApproveCustomers a = new ApproveCustomers();

        if (button.equals("Approve")) {
            if (a.selectOnlinePortal(acno)) {
                response.sendRedirect("customerApprovedMessage.jsp");
            } else {
                response.sendRedirect("customerNotApprovedMessage.jsp");
            }
        }
    }

}
