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
import lk.virtualbank.beans.UserDetails;

/**
 *
 * @author Ludowica
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

    String password = "";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //data passed from the HTML form
        String button = request.getParameter("button");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String address = request.getParameter("address");
        String gender = request.getParameter("gender");
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");
        String nic = request.getParameter("nic");
        String actype = request.getParameter("actype");
        String acno = request.getParameter("acno");
        String pass;
        //creating an object
        UserDetails reg = new UserDetails();
        String[] array = new String[5];

        if (button.equals("Register")) {

            //checking whether the customer already has an online portal
            if (reg.checkUser(acno)) {
                //if not, continue registering the customer for an online portal
                pass = reg.generatePassword(nic);

                if (reg.registerUser(fname, lname, address, gender, telephone, email, nic, acno, nic, pass)) {

                    array[0] = nic;
                    array[1] = pass;

                    request.setAttribute("array", array);
                    request.getRequestDispatcher("registersuccess.jsp").forward(request, response);
                }

            } 
            else {
                response.sendRedirect("alreadyExist.jsp");
            }
        } else {
            response.sendRedirect("index.jsp?retry=1.jsp");
        }

    }

}
