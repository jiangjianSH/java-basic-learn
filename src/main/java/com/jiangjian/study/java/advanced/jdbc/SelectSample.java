package com.jiangjian.study.java.advanced.jdbc;

import java.sql.*;

public class SelectSample {
    public static void main(String[] args) throws InterruptedException {
        try (
                Connection connection = DriverManager.getConnection(Constant.url, Constant.username, Constant.password);
                Statement stat = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ) {
            String selectSql = "select *  from user";
            ResultSet rs = stat.executeQuery(selectSql);

            System.out.println("first_name column index:" + rs.findColumn("name"));
            while(rs.next()) {
                System.out.print(rs.getString(1) + " ");

            }

            rs.previous();
            rs.previous();

            Thread.sleep(8000L);
            System.out.println("--------------");
            while(rs.next()) {
                System.out.print(rs.getString(1) + " ");
                System.out.print(rs.getString(2) + " ");
                System.out.println(rs.getString(3));
            }
            rs.moveToInsertRow();
            rs.updateInt(1, 6);
            rs.updateString(2, "jj");
            rs.updateString(3, "xx");
            rs.insertRow();
            rs.beforeFirst();
            rs.next();
            rs.updateString("first_name", "bom");
            rs.updateRow();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
