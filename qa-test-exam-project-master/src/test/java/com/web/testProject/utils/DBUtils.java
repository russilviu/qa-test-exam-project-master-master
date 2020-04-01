package com.web.testProject.utils;

import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rus on 02.05.2017.
 */
@Component
public class DBUtils {

    private final static String URL = "jdbc:mysql://localhost:3306/automation_teste";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println(DBUtils.dbRead());
    }

    public static List<Classes> dbRead() throws ClassNotFoundException, SQLException {
        List<Classes> list = new ArrayList<>();

        // 1.Load the driver
        java.lang.Class.forName("com.mysql.jdbc.Driver");

        // 2.Obtain Connection
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 3.Create a query statement
        Statement statement = connection.createStatement();

        // 4. Execute a query
        ResultSet resultSet = statement.executeQuery("SELECT name,trainer,description FROM cursuri");

        // 5. Iterate the result set and print the values
        while (resultSet.next()) {
            String name = resultSet.getString("name").trim();
            String description = resultSet.getString("description").trim();
            String trainer = resultSet.getString("trainer").trim();
            Classes classesElements = new Classes(name, description, trainer);
            list.add(classesElements);
        }

        // 6. Close the objects
        resultSet.close();
        statement.close();
        connection.close();

        return list;
    }

}
