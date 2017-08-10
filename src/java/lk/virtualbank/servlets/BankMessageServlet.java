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
import lk.virtualbank.beans.Message;

/**
 *
 * @author Ludowica
 */
@WebServlet(name = "BankMessageServlet", urlPatterns = {"/BankMessageServlet"})
public class BankMessageServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sender = request.getParameter("sender");
        String message = request.getParameter("message");
        String receiver = request.getParameter("receiver");
        String acno = request.getParameter("acno");
        String button = request.getParameter("button");

        //creating object
        Message msg = new Message();
        
        //if bank manager sends a message the following methods are called
        if (button.equals("Send to customer")) {
            if (msg.checkReceiver(acno)) {
                if (msg.bankSendMessage(sender, message, acno)) {
                    response.sendRedirect("messageSent.jsp");
                } else {
                    response.sendRedirect("messageNotSent.jsp");
                }
            } else {
                response.sendRedirect("accountNotExist.jsp");
            }
        }
        
        //if the credit card manager sends a message the following methods are called
        else if(button.equals("Send")){
            if(msg.checkReceiver(acno)){
                if(msg.bankSendMessage(sender, message, acno)){
                    response.sendRedirect("messageSent.jsp");
                }
                else{
                    response.sendRedirect("messageNotSent.jsp");
                }
            }
            else{
                response.sendRedirect("accountNotExist.jsp");
            }
        }

    }

}
