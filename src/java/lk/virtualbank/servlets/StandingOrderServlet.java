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
import lk.virtualbank.beans.ApprovedSavingsAcc;

/**
 *
 * @author Ludowica
 */
@WebServlet(name = "StandingOrderServlet", urlPatterns = {"/StandingOrderServlet"})
public class StandingOrderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acno = request.getParameter("acno");
        String receiver = request.getParameter("receiver");
        double amount = Double.parseDouble(request.getParameter("amount"));
        String type = request.getParameter("type");
        
        String[] loginArray = (String[]) request.getSession().getAttribute("loginArray");
        String nic = loginArray[0];

        ApprovedSavingsAcc sac = new ApprovedSavingsAcc();
        if (sac.createStandingorder(acno, receiver, amount, type,nic)) {
            response.sendRedirect("standingOrderSuccess.jsp");
        }
        else{
            response.sendRedirect("standingOrderNotSucess.jsp");
        }
    }

}
