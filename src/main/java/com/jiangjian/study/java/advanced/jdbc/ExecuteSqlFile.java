package com.jiangjian.study.java.advanced.jdbc;

import java.io.IOException;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Scanner;

public class ExecuteSqlFile {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost/COREJAVA?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String username = "root";
        String password = "root";
        try {
            Scanner in = args.length == 0 ? new Scanner(System.in) : new Scanner(Paths.get(args[0]));
            try (Connection conn = DriverManager.getConnection(url, username, password))
            {
                Statement stat = conn.createStatement();
                while(true) {
                    if(args.length == 0) System.out.println("Please input command or EXIT to exit");
                    if(!in.hasNext())  return;
                    String line = in.nextLine();
                    System.out.println("Sql: " + line);
                    if(line.equalsIgnoreCase("EXIT")) return;
                    if(line.trim().endsWith(";")) {
                        line = line.trim();
                        line = line.substring(0, line.length() - 1);
                    }
                    boolean isResult = stat.execute(line);
                    if(isResult) {
                        ResultSet rs = stat.getResultSet();
                        showResultSet(rs);
                    }else {
                        int updateCount = stat.getUpdateCount();
                        System.out.println(updateCount + " rows updated");
                    }

                }
            } catch (SQLException e) {
                for(Throwable t : e)  {
                    t.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showResultSet(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        int columnNum = metaData.getColumnCount();
        for(int i = 1; i <= columnNum; i++) {
            if(i > 1) System.out.print(", ");
            System.out.print(metaData.getColumnName(i));
        }
        System.out.println();
        while(rs.next()) {
            for(int i = 1; i<= columnNum; i++) {
                if(i > 1) System.out.print(", ");
                System.out.print(rs.getString(i));
            }
        }
        System.out.println();
    }

}
