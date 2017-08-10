/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.virtualbank.servlets;

import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lk.virtualbank.beans.PendingFixedAcc;

@WebServlet(name = "RegisterFixedDepositServlet", urlPatterns = {"/RegisterFixedDepositServlet"})
public class RegisterFixedDepositServlet extends HttpServlet {

    String acno = "";
    double newAmount = 0.0;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String button = request.getParameter("button");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String address = request.getParameter("address");
        String gender = request.getParameter("gender");
        String telephone = request.getParameter("telephone");
        String nic = request.getParameter("nic");
        double amount = Double.parseDouble(request.getParameter("amount"));
        String term = request.getParameter("term");
        String acc;
        
        PendingFixedAcc regF = new PendingFixedAcc();

        if (button.equals("Submit Fixed")) {
            //if so, customer is allowed to open a Savings account
            if ((acc = regF.registerFixed(fname, lname, gender, telephone, nic, amount, term, acno)) != null) {
                String[] array = new String[5];
                array[0] = acc;
                request.setAttribute("array", array);
                request.getRequestDispatcher("registerFixedSuccess.jsp").forward(request, response);
            } else {
                response.sendRedirect("index.jsp");
            }
        } else {
            response.sendRedirect("dashboard.jsp?retry=1"); //redirected to this page if an error occurs.
        }

    }

}
