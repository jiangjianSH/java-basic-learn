package com.jiangjian.study.java.advanced.jdbc;

import java.sql.*;

public class PreParedStatement {
    public static void main(String[] args) {
        try (
                Connection connection = DriverManager.getConnection(Constant.url, Constant.username, Constant.password);
        ) {
            String selectSql = "select *  from user where id=?";
            PreparedStatement stat = connection.prepareStatement(selectSql);
            stat.setInt(1, 1);
            stat.execute();
            ResultSet rs = stat.getResultSet();
            System.out.println("id column index:" + rs.findColumn("id"));
            System.out.println("first_name column index:" + rs.findColumn("first_name"));
            System.out.println("last_name column index: " + rs.findColumn("last_name"));
            System.out.println("result set type is " + rs.getType());
            while(rs.next()) {
                System.out.print(rs.getString(1) + " ");
                System.out.print(rs.getString(2) + " ");
                System.out.println(rs.getString(3));

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
