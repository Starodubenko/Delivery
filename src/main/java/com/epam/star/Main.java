package com.epam.star;

import com.epam.star.action.ActionFactory;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {

        ActionFactory.getAllAction();

//        Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/F:/Видео Epam/db/FPDB", "Rody", "1");
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery("SELECT * FROM APPOINTMENTS");
//        while (resultSet.next()){
//            System.out.println(resultSet.getArray(2));
//        }
//        connection.close();
    }
}
