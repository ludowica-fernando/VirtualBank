/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.virtualbank.beans;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import lk.virtualbank.dao.DbConnector;

/**
 *
 * @author Ludowica
 */
public class PendingFixedAcc{

    Connection con;
    Statement stmt;
    private String fname;
    private String lname;
    private String gender;
    private String telephone;
    private String nic;
    private double amount;
    private String term;
    private String acno;

    public PendingFixedAcc() {
        this.setCon(new DbConnector().connectDb());
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public String registerFixed(String fname, String lname, String gender, String telephone, String nic, double amount, String term, String acno) {
        boolean flag = false;
        int acc;
        Random rnd = new Random();
        acc = rnd.nextInt(999999) + 1; //generates a random number for the fixed deposit account number
        acno = Integer.toString(acc);

        double interest = 0.0;
        double newAmount = 0;

        try {
            stmt = con.createStatement();
            //retrieves the interest from the table
            String readInterest = "SELECT * FROM INTERESTRATES where TYPE = 'fixed' and PERIOD = '" + term + "'";
            ResultSet rs = stmt.executeQuery(readInterest);

            while (rs.next()) {
                interest = rs.getDouble("currentrate");//retrieves the current interest rate to use for calculations
            }

            //casting the String value to double for calculations
            double termValue = Double.parseDouble(term);

            //calculating the final amount of the fixed deposit after the entered term
            newAmount = ((amount + (amount * interest)) * termValue);

        } catch (SQLException ex) {

        }

        try {
            stmt = con.createStatement();
            //enters new details to the pending list for approval
            String sql = "INSERT INTO PENDINGFIXEDACC (fname, lname, gender, tel, nic, amount, term, acno, newamount) VALUES ('" + fname + "' , '" + lname + "' , '" + gender + "' , '" + telephone + "' , '" + nic + "', " + amount + " , '" + term + "', '" + acno + "', " + newAmount + ") ";
            if (stmt.executeUpdate(sql) > 0) {
                flag = true;
            }
        } catch (SQLException err) {
            System.err.println(err.getMessage());
        }

        return acno;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getAcno() {
        return acno;
    }

    public void setAcno(String acno) {
        this.acno = acno;
    }

}
