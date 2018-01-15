package com.jiangjian.study.java.advanced.jdbc;

import java.sql.*;

public class UpdateSample {
    public static void main(String[] args) {
        try (
                Connection connection = DriverManager.getConnection(Constant.url, Constant.username, Constant.password);
                Statement stat = connection.createStatement();
        ) {
            String updateSql = "update user set last_name = 'sol' where id = 1";
            int updatedNum = stat.executeUpdate(updateSql);
            System.out.println("更新的数量为:" + updatedNum);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
