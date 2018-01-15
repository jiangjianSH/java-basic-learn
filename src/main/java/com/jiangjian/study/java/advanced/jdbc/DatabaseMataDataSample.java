package com.jiangjian.study.java.advanced.jdbc;

import java.sql.*;

public class DatabaseMataDataSample {
    public static void main(String[] args) {
        try (
                Connection connection = DriverManager.getConnection(Constant.url, Constant.username, Constant.password);
        ) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
