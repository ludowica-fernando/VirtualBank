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
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.virtualbank.dao.DbConnector;

/**
 *
 * @author Ludowica
 */
public class InterestRates {

    private String type;
    private String period;
    private double prerate;
    private double currentrate;
    Connection con;
    Statement stmt;

    public InterestRates() {
        this.setCon(new DbConnector().connectDb());
    }

    //method to update interest rates
    public boolean updateInterestRate(String type, String period, double prerate, double currentrate) {
        boolean flag = false;

        try {
            stmt = con.createStatement();
            //updates the interest rates
            String updateSQL = "INSERT INTO INTERESTRATES (type, period, prerate, currentrate) VALUES ('" + type + "', '" + period + "'," + prerate + ", " + currentrate + ")";

            if (stmt.executeUpdate(updateSQL) > 0) {
                flag = true;
            }

        } catch (SQLException ex) {

        }

        return flag;
    }

    public boolean viewInterest(String interesttype, double newRate, String newPeriod) {
        boolean flag = false;
        double oldRate = 0.0;
        try {
            stmt = con.createStatement();
            String readInterest = "SELECT * FROM INTERESTRATES WHERE TYPE = '" + interesttype + "'";
            ResultSet rs = stmt.executeQuery(readInterest);

            while (rs.next()) {
                oldRate = rs.getDouble("currentrate");
                newPeriod = rs.getString("period");
                flag = true;
            }

            String update = "UPDATE INTERESTRATES SET prerate = " + oldRate + ", currentrate = " + newRate + " WHERE type = '" + interesttype + "' AND period = '" + newPeriod + "'";
            if (stmt.executeUpdate(update) > 0) {
                flag = true;
            }

        } catch (SQLException ex) {

        }
        return flag;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public double getPrerate() {
        return prerate;
    }

    public void setPrerate(double prerate) {
        this.prerate = prerate;
    }

    public double getCurrentrate() {
        return currentrate;
    }

    public void setCurrentrate(double currentrate) {
        this.currentrate = currentrate;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

}
