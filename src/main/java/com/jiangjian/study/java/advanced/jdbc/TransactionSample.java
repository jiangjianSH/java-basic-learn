package com.jiangjian.study.java.advanced.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionSample {
    public static void main(String[] args) throws SQLException {
        Statement statement = null;
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(Constant.url, Constant.username, Constant.password);
            connection.setAutoCommit(false);

            statement = connection.createStatement();
            statement.executeUpdate("update user set first_name='33332sssww'");
            connection.rollback();

           // throw new RuntimeException();
        } catch (Exception e) {
            e.printStackTrace();

        }finally {
            if(statement != null) {
                statement.close();
            }
            if(connection != null) {
                connection.close();
            }
        }
    }
}
