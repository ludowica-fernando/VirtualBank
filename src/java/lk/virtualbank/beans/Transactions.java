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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import lk.virtualbank.dao.DbConnector;

/**
 *
 * @author Ludowica
 */
public class Transactions {

    private String tvtype;
    private double amount;
    private String contractno;
    private String acno;
    private String name;
    private String paymenttype;
    private String company;
    private String insurancetype;
    private String internettype;
    private String telephonetype;
    private String telephone;
    private String date;
    Connection con;
    Statement stmt;

    //constructor
    public Transactions() {
        this.setCon(new DbConnector().connectDb());
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    //method to check whether the payer exists
    public boolean checkPayer(String acno) {
        boolean flag = false;
        String checkAcc = "";

        try {
            stmt = con.createStatement();
            //checking whether the payer has a valid account
            String sqlCheck = "select * from APPROVEDSAVINGSACC where acno = '" + acno + "' ";
            ResultSet rs = stmt.executeQuery(sqlCheck);

            while (rs.next()) {
                checkAcc = rs.getString("acno"); //if it exists, the account number is retrieved
                flag = true;
            }//end while
        } catch (SQLException ex) {
        }
        return flag;
    }//end checkPayer()

    //method to check whether the balance is valid
    public boolean checkBalance(String acno) {
        boolean flag = false;
        double currentBalance = 0; //creating a variable to store the current balance

        try {
            stmt = con.createStatement();
            //retrieving the details from the table
            String sqlCheck = "select * from APPROVEDSAVINGSACC where acno = '" + acno + "' ";
            ResultSet rs = stmt.executeQuery(sqlCheck);

            //going through each row and grabbing the balance of the searched account number
            while (rs.next()) {
                currentBalance = rs.getDouble("balance"); //retrieving the current balance and assigning it to the variable
            }//end while

            //checking whether the balance is valid
            if (currentBalance >= 100) {
                flag = true; //returns true if it is valid
            }
        } catch (SQLException ex) {
        }
        return flag;
    }//end checkBalance() method

    //method to update the balance once the transaction is done
    public boolean updateBalance(double amount, String acno) {
        boolean flag = false;
        double currentBalance = 0, newBalance = 0;

        try {
            stmt = con.createStatement();
            //retrieves details from the table
            String readSQL = "SELECT * FROM APPROVEDSAVINGSACC WHERE acno = '" + acno + "' ";
            ResultSet rs = stmt.executeQuery(readSQL);

            while (rs.next()) {
                currentBalance = rs.getDouble("balance"); //retrieves the current balance and assigns it to the currentBalance variable
                acno = rs.getString("acno"); //retrieves the account number of the customer

            }//end while

            newBalance = currentBalance - amount; //calculates the current balance after the transaction
            
            //updates the savings table once the new current balance is calculated
            String sql = "UPDATE APPROVEDSAVINGSACC SET balance = " + newBalance + " WHERE acno = '" + acno + "' ";

            if (stmt.executeUpdate(sql) > 0) {
                flag = true; //returns true if the update is done
            }//end if

        } catch (SQLException ex) {

        }

        return flag;
    } //end updateBalance() method

    public boolean addTV(String tvtype, double amount, String acno, String date, String nic) {
        boolean flag = false;
        try {
            stmt = con.createStatement();
            //inserts details of the transaction to the table
            String d = "insert into transactions values('" + tvtype + "'," + amount + ",'" + acno + "','" + date + "' ,'" + nic + "' )";

            if (stmt.executeUpdate(d) > 0) {
                flag = true;
            }//end if

        } catch (SQLException ex) {
        }
        return flag;
    }//end addTv() method

    public boolean addInternet(String internettype, double amount, String acno, String date, String nic) {
        boolean flag = false;
        try {

            stmt = con.createStatement();
            //inserts details of the transaction to the table
            String d = "insert into transactions values('" + internettype + "'," + amount + ",'" + acno + "','" + date + "', '"+nic+"')";

            if (stmt.executeUpdate(d) > 0) {
                flag = true;
            }//end if

        } catch (SQLException ex) {
        }
        return flag;
    }//end addInternet() method

    public boolean addTelephone(String telephonetype, double amount, String acno, String date, String nic) {
        boolean flag = false;
        try {

            stmt = con.createStatement();
            //inserts details of the transaction to the table
            String d = "insert into transactions values('" + telephonetype + "'," + amount + ",'" + acno + "','" + date + "', '"+nic+"')";

            if (stmt.executeUpdate(d) > 0) {
                flag = true;
            }//end if

        } catch (SQLException ex) {
        }
        return flag;
    }//end addTelephone() method

    public boolean addInsurance(String insurancetype, double amount, String acno, String date, String nic) {
        boolean flag = false;
        try {

            stmt = con.createStatement();
            //inserts details of the transaction to the table
            String d = "insert into transactions values('" + insurancetype + "'," + amount + ",'" + acno + "','" + date + "', '"+nic+"')";

            if (stmt.executeUpdate(d) > 0) {
                flag = true;
            }//end if

        } catch (SQLException ex) {
        }
        return flag;
    }//end addInsurance() method

    public boolean addElecWater(String paymenttype, double amount, String acno, String date, String nic) {
        boolean flag = false;
        try {

            stmt = con.createStatement();
            //inserts details of the transaction to the table
            String d = "insert into transactions values('" + paymenttype + "'," + amount + ",'" + acno + "','" + date + "', '"+nic+"')";

            if (stmt.executeUpdate(d) > 0) {
                flag = true;
            }//end if

        } catch (SQLException ex) {
        }
        return flag;
    }//end addElecWater() method

    //method to deal with the place standing orders
    public boolean addUtility(String paymenttype, double amount, String acno, String nic) {
        boolean flag = false;
        try {
            LocalDate localDate = LocalDate.now();
            String date = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(localDate);

            stmt = con.createStatement();
            String d = "insert into transactions values('" + paymenttype + "'," + amount + ",'" + acno + "','" + date + "','" + nic + "')";

            if (stmt.executeUpdate(d) > 0) {
                flag = true;
            }//end if

        } catch (SQLException ex) {
        }
        return flag;
    }//end addUtility() method

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getContractno() {
        return contractno;
    }

    public void setContractno(String contractno) {
        this.contractno = contractno;
    }

    public String getAcno() {
        return acno;
    }

    public void setAcno(String acno) {
        this.acno = acno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPaymenttype() {
        return paymenttype;
    }

    public void setPaymenttype(String paymenttype) {
        this.paymenttype = paymenttype;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getInsurancetype() {
        return insurancetype;
    }

    public void setInsurancetype(String insurancetype) {
        this.insurancetype = insurancetype;
    }

    public String getInternettype() {
        return internettype;
    }

    public void setInternettype(String internettype) {
        this.internettype = internettype;
    }

    public String getTelephonetype() {
        return telephonetype;
    }

    public void setTelephonetype(String telephonetype) {
        this.telephonetype = telephonetype;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTvtype() {
        return tvtype;
    }

    public void setTvtype(String tvtype) {
        this.tvtype = tvtype;
    }
}
