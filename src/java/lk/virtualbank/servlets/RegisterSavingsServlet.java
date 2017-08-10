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
import lk.virtualbank.beans.FundTransfers;
import lk.virtualbank.beans.PendingSavingsAcc;

/**
 *
 * @author Ludowica
 */
@WebServlet(name = "RegisterSavingsServlet", urlPatterns = {"/RegisterSavingsServlet"})
public class RegisterSavingsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //data passed from the HTML form
        String button = request.getParameter("button");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String gender = request.getParameter("gender");
        String telephone = request.getParameter("telephone");
        String nic = request.getParameter("nic");
        double balance = Double.parseDouble(request.getParameter("amount"));
        String acnoFrom = request.getParameter("acnoFrom");
        String acc;

        //creating an object
        PendingSavingsAcc regS = new PendingSavingsAcc();
        FundTransfers f = new FundTransfers();

        //checking if the "Submit Savings" button was clicked
        if (button.equals("Submit Savings")) {
            //if so, customer is allowed to open a Savings account
            if ((acc = regS.registerSavings(fname, lname, gender, telephone, nic, balance)) != null) {
                if ((f.checkSender(acnoFrom)) && f.checkBalance(acnoFrom)) {
                    if (f.updateAc(acnoFrom, balance)) {
                        if (f.doInitTransfer(acc, balance)) {
                            String[] array = new String[5];
                            array[0] = acc;
                            request.setAttribute("array", array);
                            request.getRequestDispatcher("registerSavingsSuccess.jsp").forward(request, response);
                        }

                    }
                }

            } else {
                response.sendRedirect("index.jsp");
            }
        } else {
            response.sendRedirect("dashboard.jsp?retry=1"); //redirected to this page if an error occurs.
        }
    }
}
