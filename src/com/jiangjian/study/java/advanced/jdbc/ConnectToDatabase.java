package com.jiangjian.study.java.advanced.jdbc;

import java.sql.*;

public class ConnectToDatabase {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost/COREJAVA?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String username = "root";
        String password = "root";
        try (Connection conn = DriverManager.getConnection(url, username, password))
        {
            DatabaseMetaData metaData = conn.getMetaData();
            System.out.println("Max support nums of statements : " + metaData.getMaxStatements());
            Statement stat = conn.createStatement();
            String sql = "select * from article";
            ResultSet rs = stat.executeQuery(sql);
            System.out.println(stat.getWarnings());
            while(rs.next()) {
                System.out.println(rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
