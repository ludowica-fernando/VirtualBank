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
import java.util.Random;
import lk.virtualbank.dao.DbConnector;

/**
 *
 * @author Ludowica
 */
public class PendingCreditCard {

    private String fname;
    private String lname;
    private String nic;
    private String acno;
    private double limit;
    private String creditcardno;
    Connection con;
    Statement stmt;

    public PendingCreditCard() {
        this.setCon(new DbConnector().connectDb());
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    //method to check whether the account from which request is made exists
    public boolean checkAccount(String acno) {
        boolean flag = true;
        try {
            stmt = con.createStatement();
            //retrieves details from the table
            String checkSQL = "select * from APPROVEDSAVINGSACC where acno='" + acno + "' ";
            ResultSet rs = stmt.executeQuery(checkSQL);

            while (rs.next()) {
                flag = true; //returns true if found
            }

        } catch (SQLException err) {
            System.err.println(err.getMessage());
        }
        return flag;
    }//end checkAccount() method
    
    public String requestCreditCard(String fname, String lname, String nic, double limit, String acno, String creditcardno) {
        boolean flag = false;
        int creditNO;
        Random rnd = new Random();
        creditNO = rnd.nextInt(999999) + 1; //generates a random number for the credit card number
        creditcardno = Integer.toString(creditNO); //assigns it to the "creditcardno" variable

        try {
            stmt = con.createStatement();
            //retrieves details from the pending list
            String sql = "INSERT INTO PENDINGCREDITCARD (fname, lname, nic, limit, acno, creditcardno) VALUES ('" + fname + "' , '" + lname + "' , '" + nic + "', " +limit+ " , '" + acno + "', '"+creditcardno+"') ";
            if (stmt.executeUpdate(sql) > 0) {
                flag = true;
            }
        } catch (SQLException err) {
            System.err.println(err.getMessage());
        }
        
        return creditcardno;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getAcno() {
        return acno;
    }

    public void setAcno(String acno) {
        this.acno = acno;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public String getCreditcardno() {
        return creditcardno;
    }

    public void setCreditcardno(String creditcardno) {
        this.creditcardno = creditcardno;
    }
}
