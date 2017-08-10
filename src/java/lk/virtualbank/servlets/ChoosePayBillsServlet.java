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

/**
 *
 * @author Ludowica
 */
@WebServlet(name = "ChoosePayBillsServlet", urlPatterns = {"/ChoosePayBillsServlet"})
public class ChoosePayBillsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String button = request.getParameter("button");

        if (button.equals("Pay Tv Bill")) {
            response.sendRedirect("paytv.jsp");
        } 
        else if (button.equals("Pay Electricity/Water Bill")) {
            response.sendRedirect("payelecwater.jsp");
        } 
        else if (button.equals("Pay Insurance Bill")) {
            response.sendRedirect("payinsurance.jsp");
        } 
        else if (button.equals("Pay Internet Bill")) {
            response.sendRedirect("payinternet.jsp");
        } 
        else if (button.equals("Pay Telephone Bill")) {
            response.sendRedirect("paytelephone.jsp");
        } 
        else if (button.equals("External Cash Transfer")) {
            response.sendRedirect("externalMoneyTransfer.jsp");
        } 
        else {
            response.sendRedirect("dashboard.jsp");
        }
    }

}
