package org.tarapadilla.utils;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private final static String url = "jdbc:mysql://database-1.c7mkyc08y2io.us-east-1.rds.amazonaws.com/project";
    private final static String user = "admin";
    private final static String password = "Bec.2024*";
    private static Connection con;
    private static BasicDataSource pool;

    public static Connection getInstanceWithCon() throws SQLException {
        if(con == null) {
            con = DriverManager.getConnection(url, user, password);
            con.setAutoCommit(false);
        }
        return con;
    }

    public static BasicDataSource getInstanceWithPool() throws SQLException {
        if(pool == null) {
            pool = new BasicDataSource();
            pool.setUrl(url);
            pool.setUsername(user);
            pool.setPassword(password);
            //pool.setDriverClassName("com.mysql.jdbc.Driver");

            pool.setInitialSize(5);
            pool.setMinIdle(5);
            pool.setMaxIdle(10);
            pool.setMaxTotal(10);
        }
        return pool;
    }

    public static Connection getConnection() throws SQLException {
        return getInstanceWithPool().getConnection();
    }

    public static void saveTransactions() throws SQLException {
        if (con == null) {
            throw new SQLException("Connection is null");
        } else
        {
          con.commit();
        }
    }
}
