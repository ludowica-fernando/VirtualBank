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
import lk.virtualbank.dao.DbConnector;

/**
 *
 * @author Ludowica
 */
public class FundTransfers {

    Connection con;
    Statement stmt;
    private String acnoTo;
    private String acnoFrom;
    private double amountSend;
    private String date;

    public FundTransfers() {
        this.setCon(new DbConnector().connectDb());
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    //method to check whether the sender exists
    public boolean checkSender(String acnoFrom) {
        boolean flag = false;
        String checkAcc = "";

        try {
            stmt = con.createStatement();
            String sqlCheck = "select * from APPROVEDSAVINGSACC where acno = '" + acnoFrom + "' ";
            ResultSet rs = stmt.executeQuery(sqlCheck);

            while (rs.next()) {
                checkAcc = rs.getString("acno");
                flag = true;
            }//end while
        } catch (SQLException ex) {
        }
        return flag;
    }//end checkSender()

    //method to check whether the receiver exists
    public boolean checkReceiver(String acnoTo) {
        boolean flag = false;
        String checkAcc = "";

        try {
            stmt = con.createStatement();
            String sqlCheck = "select * from APPROVEDSAVINGSACC where acno = '" + acnoTo + "' ";
            ResultSet rs = stmt.executeQuery(sqlCheck);

            while (rs.next()) {
                checkAcc = rs.getString("acno");
                flag = true;
            }//end while
        } catch (SQLException ex) {
        }
        return flag;
    }//end checkReceiver()

    //method to transfer and update the receivers account
    public boolean doTransfer(String acnoTo, Double amountSend) {
        boolean flag = false;
        double currentBalance = 0;

        try {
            stmt = con.createStatement();
            String sql1 = "select * from APPROVEDSAVINGSACC where acno = '" + acnoTo + "'";
            ResultSet rs = stmt.executeQuery(sql1);

            while (rs.next()) {
                currentBalance = rs.getDouble("balance"); //retrieves the current balance of the receiver

            }//end while

            double ntotal = currentBalance + amountSend; //calculates the new balance after the amount sent is added
            String sql = "UPDATE APPROVEDSAVINGSACC   SET balance = " + ntotal + " WHERE acno = '" + acnoTo + "' ";

            if (stmt.executeUpdate(sql) > 0) {
                flag = true;
            }//end if

        } catch (SQLException err) {
            System.err.println(err.getMessage());
        }

        return flag;
    }// end doTransfer()

    //method to transfer and update the senders account
    public boolean updateAc(String acnoFrom, double amountSend) {
        boolean flag = false;
        double currentBalance = 0, newBalance = 0;

        try {
            stmt = con.createStatement();
            //retrieves details of the sender from the approved list
            String readSQL = "SELECT * FROM APPROVEDSAVINGSACC WHERE acno = '" + acnoFrom + "' ";
            ResultSet rs = stmt.executeQuery(readSQL);

            while (rs.next()) {
                currentBalance = rs.getDouble("balance"); //retrieves the current balance of the sender
                acnoFrom = rs.getString("acno"); //retrieves the account number of the sender

            }//end while

            newBalance = currentBalance - amountSend; //calculates the new balance of the sender after the amount sent is deducted
            //updates the new current balance of the sender
            String sql = "UPDATE APPROVEDSAVINGSACC SET balance = " + newBalance + " WHERE acno = '" + acnoFrom + "' ";

            if (stmt.executeUpdate(sql) > 0) {
                flag = true;
            }//end if

        } catch (SQLException ex) {

        }

        return flag;
    }//end updateAc()

    //method to check the balance of the sender
    public boolean checkBalance(String acnoFrom) {
        boolean flag = false;
        double currentBalance = 0;

        try {
            stmt = con.createStatement();
            //retrieves
            String sqlCheck = "select * from APPROVEDSAVINGSACC where acno = '" + acnoFrom + "' ";
            ResultSet rs = stmt.executeQuery(sqlCheck);

            //going through each row and grabbing the balance of the searched account number
            while (rs.next()) {
                currentBalance = rs.getDouble("balance");
            }//end while

            //checking whether the balance is valid
            if (currentBalance >= 100) {
                flag = true;
            }
        } catch (SQLException ex) {
        }
        return flag;
    }//end checkBalance() method

    public boolean updateTransfer(String acnoFrom, String acnoTo, double amount, String date) {
        boolean flag = false;
        try {
            stmt = con.createStatement();
            String sql = "INSERT INTO FUNDTRANSFERS (sender, receiver, amount, date) VALUES ('" + acnoFrom + "' , '" + acnoTo + "' , " + amount + "  , '" + date + "') ";

            if (stmt.executeUpdate(sql) > 0) {
                flag = true;
            }//end if

        } catch (SQLException err) {
            System.err.println(err.getMessage());
        }
        return flag;
    }//end updateTransfer() method
    
    public boolean doInitTransfer(String acnoTo, Double amountSend) {
        boolean flag = false;
        double currentBalance = 0;

        try {
            stmt = con.createStatement();
            String sql1 = "select * from PENDINGSAVINGSACC where acno = '" + acnoTo + "'";
            ResultSet rs = stmt.executeQuery(sql1);

            while (rs.next()) {
                currentBalance = rs.getDouble("balance");

            }//end while

            double ntotal = currentBalance + amountSend;
            String sql = "UPDATE PENDINGSAVINGSACC SET balance = " + ntotal + " WHERE acno = '" + acnoTo + "' ";

            if (stmt.executeUpdate(sql) > 0) {
                flag = true;
            }//end if

        } catch (SQLException err) {
            System.err.println(err.getMessage());
        }

        return flag;
    }// end doInitTransfer()

    public String getAcnoTo() {
        return acnoTo;
    }

    public void setAcnoTo(String acnoTo) {
        this.acnoTo = acnoTo;
    }

    public String getAcnoFrom() {
        return acnoFrom;
    }

    public void setAcnoFrom(String acnoFrom) {
        this.acnoFrom = acnoFrom;
    }

    public double getAmountSend() {
        return amountSend;
    }

    public void setAmountSend(double amountSend) {
        this.amountSend = amountSend;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
