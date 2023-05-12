package com.example.project_351.model.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements Repository<User> {

    private String sql;

    @Override
    public List<User> listAllObj() throws SQLException {
        sql = "SELECT user_id, user_firstname, user_lastname, user_email, user_password FROM users_tbl ORDER BY user_lastname, user_firstname";
        List<User> users = new ArrayList<>();
        try (Connection conn = ConnectionPool.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                User user = new User();
                user.setUser_id(rs.getInt("user_id"));
                user.setUser_firstname(rs.getString("user_firstname"));
                user.setUser_lastname(rs.getString("user_lastname"));
                user.setUser_email(rs.getString("user_email"));
                user.setUser_password(rs.getString("user_password"));
                users.add(user);
            }
        }
        return users;
    }

    @Override
    public User getByIdObj(Integer id) throws SQLException {
        // Implementar lógica para obtener un usuario por ID
        return null;
    }

    @Override
    public Integer saveObj(User user) throws SQLException {
        int rowsAffected = 0;
        String sql;
        if (user.getUser_id() != null && user.getUser_id() > 0) {
            sql = "update users_tbl set user_firstname=?, user_lastname=?, user_email=?, user_password=aes_encrypt(?, '$2a$12$71SJ2B6qdXDQrZUF4K5suDytQ062kLQf/QHbatSw8wLqulDoMppm') where user_id=?";
        } else {
            sql = "insert into users_tbl(user_firstname, user_lastname, user_email, user_password) values(upper(?), lower(?), ?, aes_encrypt(?, '$2a$12$71SJ2B6qdXDQrZUF4K5suDytQ062kLQf/QHbatSw8wLqulDoMppm'))";
        }
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getUser_firstname());
            ps.setString(2, user.getUser_lastname());
            ps.setString(3, user.getUser_email());
            ps.setString(4, user.getUser_password());
            if (user.getUser_id() != null && user.getUser_id() > 0) {
                ps.setObject(5, user.getUser_id());
            }
            rowsAffected = ps.executeUpdate();
        }
        return rowsAffected;
    }

    @Override
    public User createObj(ResultSet rs) throws SQLException {
        // Implementar lógica para crear un usuario a partir de un ResultSet
        return null;
    }
}

