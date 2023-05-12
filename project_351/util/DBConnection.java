package com.example.project_351.util;

import java.sql.Connection;
import java.sql.SQLException;


public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/my_app";
    private static final String USER = "my_app_user";
    private static final String PASS = "my_app_password";
    private static BasicDataSource pool;

    private DBConnection() {
        // Constructor privado para evitar la creación de instancias
    }

    public static Connection getConnection() throws SQLException {
        if (pool == null) {
            pool = new BasicDataSource();
            pool.setUrl(URL);
            pool.setUsername(USER);
            pool.setPassword(PASS);
            pool.setInitialSize(3);
            pool.setMinIdle(3);
            pool.setMaxIdle(8);
            pool.setMaxTotal(8);
        }
        return pool.getConnection();
    }
}
