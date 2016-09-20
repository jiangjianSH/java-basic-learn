package com.jiangjian.study.java.advanced.jdbc;

import org.h2.jdbcx.JdbcDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Administrator on 2016/9/8 0008.
 */
public class JDBCSample {
    public static void main(String... args) throws SQLException {
        Connection connection = DriverManager.getConnection("org.h2.Driver", "sa", "");
        connection.close();
    }
}
