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
import lk.virtualbank.beans.InterestRates;

/**
 *
 * @author Ludowica
 */
@WebServlet(name = "UpdateInterestServlet", urlPatterns = {"/UpdateInterestServlet"})
public class UpdateInterestServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String interesttype = request.getParameter("interesttype");
        String newPeriod = request.getParameter("newPeriod");
        double newRate = Double.parseDouble(request.getParameter("newrate"));
        
        InterestRates ir = new InterestRates();
        
        if(ir.viewInterest(interesttype, newRate, newPeriod)){
            response.sendRedirect("successPage.jsp");
        }
        else{
            response.sendRedirect("index.jsp");
        }
        
    }
    
}
