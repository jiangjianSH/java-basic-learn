package com.jiangjian.study.java.advanced.jdbc;

import javax.xml.crypto.Data;
import java.sql.*;

public class PreparedStatementDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost/COREJAVA?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String username = "root";
        String password = "root";
        try (Connection conn = DriverManager.getConnection(url, username, password))
        {
            DatabaseMetaData metaData = conn.getMetaData();
            System.out.println("database support result set only forward: " + metaData.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY));
            System.out.println("database support result set sensitive : " + metaData.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE));
            System.out.println("database support result set insensitive : " + metaData.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE));
            String sql = "select * from tag;";
            Statement stat = conn.createStatement();
            boolean isResult = stat.execute(sql);
            while(true) {
                if(isResult) {
                    displayResult(stat.getResultSet());
                } else {
                    if(stat.getUpdateCount() == -1) break;
                    System.out.println( stat.getUpdateCount() + " rowsUpdated ");
                }
                isResult = stat.getMoreResults();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void displayResult(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        int countNum = metaData.getColumnCount();
        for(int i = 1; i <= countNum; i++) {
            if(i > 1) System.out.print(" ,");
            System.out.print(metaData.getColumnName(i));
        }
        System.out.println();

        while(rs.next()) {
            for(int i = 1; i <= countNum; i++) {
                if(i > 1) System.out.print(" ,");
                System.out.print(rs.getString(i));
            }
            System.out.println();
        }
        System.out.println();
    }
}
