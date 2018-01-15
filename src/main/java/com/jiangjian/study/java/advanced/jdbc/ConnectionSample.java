package com.jiangjian.study.java.advanced.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSample {
    public static void main(String[] args) {
        try (
                Connection connection = DriverManager.getConnection(Constant.url, Constant.username, Constant.password);
        ) {
            System.out.println("isClosed: " + connection.isClosed());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
