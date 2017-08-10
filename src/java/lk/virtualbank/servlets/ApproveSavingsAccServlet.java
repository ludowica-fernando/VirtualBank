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
import lk.virtualbank.beans.ApprovedSavingsAcc;

/**
 *
 * @author Ludowica
 */
@WebServlet(name = "ApproveSavingsAccServlet", urlPatterns = {"/ApproveSavingsAccServlet"})
public class ApproveSavingsAccServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fname = "";
        String lname = "";
        String gender = "";
        String telephone = "";
        String nic = "";
        double balance = 0.0;
        String acno = request.getParameter("acno");
        String button = request.getParameter("button");
        
        ApprovedSavingsAcc a = new ApprovedSavingsAcc();
        
        if (button.equals("Approve")) {
            if (a.approveSavings(fname, lname, gender, telephone, nic, balance, acno)) {
                response.sendRedirect("customerApprovedMessage.jsp");
            } else {
                response.sendRedirect("customerNotApprovedMessage.jsp");
            }
        }
        

    }

}
