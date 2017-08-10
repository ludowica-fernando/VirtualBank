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
public class ApproveCreditCard {

    private String fname;
    private String lname;
    private String nic;
    private String acno;
    private double limit;
    private double availablebalance;
    private double outstandingbalance;
    private String creditcardno;
    Connection con;
    Statement stmt;

    public ApproveCreditCard() {
        this.setCon(new DbConnector().connectDb());
    }

    //method to approve the credit card requests
    public boolean selectCreditCard(String creditcardno) {
        boolean flag = false;
        try {
            stmt = con.createStatement();
            
            //retrieves requests from the pending credit card list
            String sqlc = "SELECT * FROM PENDINGCREDITCARD WHERE creditcardno = '" + creditcardno + "' ";
            ResultSet rs = stmt.executeQuery(sqlc);
            while (rs.next()) {
                //retrieves the following column data
                fname = rs.getString("fname");
                lname = rs.getString("lname");
                nic = rs.getString("nic");
                acno = rs.getString("acno");
                limit = rs.getDouble("limit");
                flag = true;
            }
            
            //once approved, details are entered into an approved table
            String sqlA = "INSERT INTO APPROVEDCREDITCARD VALUES ('" + fname + "' , '" + lname + "', '" + nic + "', '" + acno + "', " + limit + ", '" + creditcardno + "', " + limit + "," + 0 + ") ";
            stmt.executeUpdate(sqlA);
            
            //once approved, the details are deleted from the request list
            String updateSQL = "DELETE FROM PENDINGCREDITCARD WHERE acno = '" + acno + "'";
            stmt.executeUpdate(updateSQL);
            flag = true;

        } catch (SQLException err) {
            System.err.println(err.getMessage());
        }

        return flag;
    }

    //method to update credit card balance after transactions
    public boolean updateCreditCard(double amount, String creditcardno) {
        boolean flag = false;
        boolean flag2 = false;
        double newBalance = 0.0;
        double newOutstandingBalance = 0.0;

        try {
            stmt = con.createStatement();
            //retrieves details of the creditcard
            String sqlc = "SELECT * FROM APPROVEDCREDITCARD WHERE creditcardno = '" + creditcardno + "' ";
            ResultSet rs = stmt.executeQuery(sqlc);
            while (rs.next()) {
                limit = rs.getDouble("limit"); //retrieves the limit of the credit card
                availablebalance = rs.getDouble("availablebalance"); //retrieves the available balance
                outstandingbalance = rs.getDouble("outstandingbalance"); //retrieves the outstanding balance
                flag = true;
            }

            //checking whether the amount is less than the actual available amount
            if (availablebalance >= amount) {
                //calculates and updates the new outstanding balance of the credit card
                newBalance = availablebalance - amount;
                newOutstandingBalance = newOutstandingBalance + amount;
                //updates table with new outstanding balance
                String updateSQL = "UPDATE APPROVEDCREDITCARD SET availablebalance = " + newBalance + ", outstandingbalance = " + newOutstandingBalance + " WHERE creditcardno = '" + creditcardno + "' ";
                if (stmt.executeUpdate(updateSQL) > 0) {
                    flag2 = true;
                }
            }

        } catch (SQLException ex) {

        }
        return flag2;
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

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public String getCreditcardno() {
        return creditcardno;
    }

    public void setCreditcardno(String creditcardno) {
        this.creditcardno = creditcardno;
    }

    public double getAvailablebalance() {
        return availablebalance;
    }

    public void setAvailablebalance(double availablebalance) {
        this.availablebalance = availablebalance;
    }

    public double getOutstandingbalance() {
        return outstandingbalance;
    }

    public void setOutstandingbalance(double outstandingbalance) {
        this.outstandingbalance = outstandingbalance;
    }

}
