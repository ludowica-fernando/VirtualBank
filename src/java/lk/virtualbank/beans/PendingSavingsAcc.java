/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.virtualbank.beans;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Random;
import lk.virtualbank.dao.DbConnector;

/**
 *
 * @author Ludowica
 */
public class PendingSavingsAcc {

    Connection con;
    Statement stmt;
    private String fname;
    private String lname;
    private String gender;
    private String telephone;
    private String nic;
    private double balance;
    private String acno;

    public PendingSavingsAcc() {
        this.setCon(new DbConnector().connectDb());
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public String registerSavings(String fname, String lname, String gender, String telephone, String nic, double balance) {
        boolean flag = false;
        int acc;
        Random rnd = new Random();
        acc = rnd.nextInt(999999) + 1; //generates a random number for the account number
        acno = Integer.toString(acc);

        try {
            stmt = con.createStatement();
            //inserts the details of the customer into a pending list for approval
            String sql = "INSERT INTO PENDINGSAVINGSACC (fname, lname, gender, tel, nic, balance, acno) VALUES ('" + fname + "' , '" + lname + "' , '" + gender + "' , '" + telephone + "' , '" + nic + "', " +balance+ " , '" + acno + "') ";
            if (stmt.executeUpdate(sql) > 0) {
                flag = true; //returns true if inserted successfully
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

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAcno() {
        return acno;
    }

    public void setAcno(String acno) {
        this.acno = acno;
    }

}
