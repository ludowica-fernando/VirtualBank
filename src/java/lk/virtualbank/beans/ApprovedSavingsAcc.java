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
import java.util.Calendar;
import lk.virtualbank.dao.DbConnector;

/**
 *
 * @author Ludowica
 */
public class ApprovedSavingsAcc {

    private String fname;
    private String lname;
    private String gender;
    private String telephone;
    private String nic;
    private double balance;
    private String acno;
    private Connection con;
    Statement stmt;

    public ApprovedSavingsAcc() {
        this.setCon(new DbConnector().connectDb());
    }

    public boolean approveSavings(String fname, String lname, String gender, String telephone, String nic, double balance, String acno) {
        boolean flag = false;
        try {
            stmt = con.createStatement();
            String sqlc = "SELECT * FROM PENDINGSAVINGSACC WHERE acno = '" + acno + "' ";
            ResultSet rs = stmt.executeQuery(sqlc);
            while (rs.next()) {
                fname = rs.getString("fname");
                lname = rs.getString("lname");
                gender = rs.getString("gender");
                telephone = rs.getString("tel");
                nic = rs.getString("nic");
                balance = rs.getDouble("balance");
                acno = rs.getString("acno");
                flag = true;
            }

            String sqlA = "INSERT INTO APPROVEDSAVINGSACC (fname, lname, gender, tel, nic, balance, acno)VALUES ('" + fname + "' , '" + lname + "' , '" + gender + "' , '" + telephone + "' , '" + nic + "', " + balance + ", '" + acno + "') ";

            if (stmt.executeUpdate(sqlA) > 0) {
                flag = true;
            }

            String updateSQL = "DELETE FROM PENDINGSAVINGSACC WHERE acno = '" + acno + "'";

            if (stmt.executeUpdate(updateSQL) > 0) {
                flag = true;
            }

        } catch (SQLException err) {
            System.err.println(err.getMessage());
        }

        return flag;
    }

    
    /*  schedule payments */
    public boolean createStandingorder(String acnofrom, String acnoto, double amount, String type, String nic) {
        boolean flag = false;
        try {
            stmt = con.createStatement();
            //inserts details into the standingorder table where it can be viewed later.
            String sql = "insert into standingorder values ('" + acnofrom + "','" + acnoto + "'," + amount + ",'" + type + "','" + nic + "')";
            stmt.executeUpdate(sql); //executes the SQL statement
            flag = true; //returns true if inserted successfully

        } catch (SQLException er) {
        }

        return flag;
    }

    public boolean payStandingorder() {
        boolean flag = false;
        String acnofrom, acnoto, type;
        double amount;

        try {
            stmt = con.createStatement();
            //retrieves data from the standingorder table
            String sql = "SELECT * FROM standingorder ";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                acnofrom = rs.getString("acnofrom"); //retrieves the applicant's account number
                acnoto = rs.getString("acnoto"); //retrieves the receiver's account number
                type = rs.getString("type"); //retrieves the type of the standing order
                amount = rs.getDouble("amount"); //retrieves the amount to be paid
                nic = rs.getString("nic"); //retrieves the NIC of the applicant

                FundTransfers funTransfer = new FundTransfers(); //creates an object to call the functions in the FundTransfers bean class
                
                //if the updateAc() method is executed successfully, the addUtility() method is also called.
                if (funTransfer.updateAc(acnofrom, amount)) {
                    Transactions tra = new Transactions();
                    tra.addUtility(type, amount, acnoto, nic); //adds the details to the transaction table
                }
            }

        } catch (Exception er) {
            System.out.println("Err" + er);
        }

        return flag;
    }

    public void methodPay() {
        Calendar cal = Calendar.getInstance();
        //gets the current date of the login
        int day = cal.get(Calendar.DAY_OF_MONTH);//get the the date
        
        //if the date is 25th of the month, the payStandingorder() method is called.
        if (day == 25) {
            payStandingorder();
        }
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

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

}
