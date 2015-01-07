/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

/**
 *
 * @author acer
 */
@Controller
public class MysqlConnectionController implements JDBCConnectionController {

    private @Value("${jdbc.driverClassName}")
    String driverClass;
    private @Value("${jdbc.url}")
    String databaseURL;
    private @Value("${jdbc.username}")
    String databaseUsername;
    private @Value("${jdbc.password}")
    String databasePassword;

    public String getDriverClass() {
        return driverClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    public String getDatabaseURL() {
        return databaseURL;
    }

    public void setDatabaseURL(String databaseURL) {
        this.databaseURL = databaseURL;
    }

    public String getDatabaseUsername() {
        return databaseUsername;
    }

    public void setDatabaseUsername(String databaseUsername) {
        this.databaseUsername = databaseUsername;
    }

    public String getDatabasePassword() {
        return databasePassword;
    }

    public void setDatabasePassword(String databasePassword) {
        this.databasePassword = databasePassword;
    }

    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(getDriverClass());

            try {

                connection = DriverManager.getConnection(getDriverClass(), getDatabaseUsername(), getDatabasePassword());
            } catch (SQLException ex) {
                ex.printStackTrace();
                Logger.getLogger(MysqlConnectionController.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            return null;
        }
        return connection;

    }
}
