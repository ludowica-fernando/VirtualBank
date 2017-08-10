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
@WebServlet(name = "CustomerMessageServlet", urlPatterns = {"/CustomerMessageServlet"})
public class CustomerMessageServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sender = request.getParameter("sender");
        String name = request.getParameter("name");
        String receiver = request.getParameter("receiver");
        String message = request.getParameter("message");
        String nic = request.getParameter("nic");
        String button = request.getParameter("button");

        //creating an object
        Message msg = new Message();

        if (button.equals("Send")) {
            if (msg.checkSender(sender)) {
                if (msg.sendMessage(name, message, receiver)) {
                    response.sendRedirect("messageSent.jsp");
                }
                else{
                    response.sendRedirect("messageNotSent.jsp");
                }
            }
            else {
                response.sendRedirect("senderNotExist.jsp");
            }

        }

    }

}
