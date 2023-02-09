package org.example;

import java.sql.*;

public class Test {

    private final String URL = "jdbc:postgresql://localhost:5433/air_travel";
    private final String USER = "postgres";
    private final String PASSWORD = "12";
    Connection connection;


    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Test() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("не удалось подключится к бд");
//            throw new RuntimeException(e);
        }
    }

    public void getTest() {
        Test test = new Test();
        String query = "select * from test";


        try {
            Statement statement = test.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println("айди " + id + " имя " + name);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void getWhereId1() {
        Test test1 = new Test();
        String guery1 = "select * from test where id = 1";
        try {
            Statement statement = test1.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(guery1);

            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                System.out.println(id + " " + name);
            }
        } catch (SQLException e) {
            System.out.println("не удалось подключится к бд");
            throw new RuntimeException(e);

        }

    }
}
