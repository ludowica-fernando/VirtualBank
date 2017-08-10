package lk.virtualbank.servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lk.virtualbank.beans.ApproveCustomers;
import lk.virtualbank.beans.ApprovedSavingsAcc;
import lk.virtualbank.beans.LoginDetail;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = null;

        HttpSession loginsession = request.getSession();
        String[] loginArray = new String[5];

        loginArray[0] = username;

        loginsession.setAttribute("loginArray", loginArray);

        LoginDetail login = new LoginDetail();
        ApproveCustomers appCust = new ApproveCustomers();

        if (login.userExist(username, password)) {
            loginArray[1] = appCust.fnameGet(username);
            RequestDispatcher rd1 = request.getRequestDispatcher("dashboard.jsp");
            rd1.forward(request, response);
            
        } else if (username.equals("admin") && password.equals("admin123")) {
            response.sendRedirect("bankHomePage.jsp");

            new ApprovedSavingsAcc().methodPay();

        } else if (username.equals("cardcenter") && password.equals("cardcenter123")) {
            response.sendRedirect("cardHomePage.jsp");
        } else {
            response.sendRedirect("index.jsp?retry=1");
        }

    }

}
