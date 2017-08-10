/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.virtualbank.beans;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import lk.virtualbank.dao.DbConnector;

/**
 *
 * @author Ludowica
 */
public class LoginDetail {

    private String username;
    private String password;
    Connection con;
    Statement stmt;

    public LoginDetail() {
        this.setCon(new DbConnector().connectDb());
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    //checking whether the user exists
    public boolean userExist(String username, String password) {
        boolean flag = false;
        try {
            stmt = con.createStatement();
            //checking against the logindetail table whether the customer exists
            String sql = "select * from LOGINDETAIL where username = '" + username + "' and password = '" + password + "'  ";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                flag = true; //returns true if the customer exists
            }

        } catch (SQLException err) {
            System.err.println(err.getMessage());
        }

        return flag;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}//end LoginDetail bean class
