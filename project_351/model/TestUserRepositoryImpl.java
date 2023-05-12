package com.example.project_351.model;

import com.example.project_351.model.repository.Repository;

import java.sql.SQLException;

public class TestUserRepositoryImpl {
    public static void main(String[] args) throws SQLException {
        Repository<User> repository = new UserRepository();

        System.out.println("========= saveObj Insert =========");// insert
        User userInsert = new User();
        userInsert.setUser_firstname("carlos");
        userInsert.setUser_lastname("rojas");
        userInsert.setUser_email("carlosrojas@gmail.com");
        userInsert.setUser_password("1256987");
        repository.saveObj(userInsert);

        userInsert.setUser_firstname("pEpE");
        userInsert.setUser_lastname("sierra");
        userInsert.setUser_email("PEPEsierra@gmail.com");
        userInsert.setUser_password("c2895756585");
        repository.saveObj(userInsert);

        System.out.println("=========listAllObj=========");
        repository.listAllObj().forEach(System.out::println);
        System.out.println();

        System.out.println("=========saveObj=========");// update
        User userUpdate = repository.getByIdObj(2);
        userUpdate.setUser_firstname("jorge");
        userUpdate.setUser_lastname("burgos");
        userUpdate.setUser_email("jorgeburgos@gmail.com");
        userUpdate.setUser_password("1057");
        repository.saveObj(userUpdate);
        repository.listAllObj().forEach(System.out::println);
        System.out.println();

        System.out.println("=========deleteObj========");
        repository.deleteObj(2);
        repository.listAllObj().forEach(System.out::println);
    }
}
