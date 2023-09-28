package com.izahabandt;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {

    public static final String DB_NAME = "meals.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\izabe\\Desktop\\whats-for-lunch\\WhatsForLunch\\" + DB_NAME;

    private Connection conn;
    public boolean open() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);
            return true;
        } catch (SQLException e) {
            System.out.println("Couldn't connect to database: " + e.getMessage());
            return false;
        }
    }
    public void close(){
        try{
            if(conn != null) {
                conn.close();
            }
        } catch(SQLException e){
            System.out.println("Couldn't close connection: " + e.getMessage());
        }
    }

    public boolean addMeal(Meal meal) {
        String sql = "INSERT INTO meals (name, description) VALUES (?, ?)";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, meal.getName());
            statement.setString(2, meal.getDescription());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            System.out.println("Error adding meal: " + e.getMessage());
            return false;
        }
    }
    public List<Meal> getRandomMealsForWeek() {
        String sql = "SELECT * FROM meals ORDER BY RANDOM() LIMIT 3";
        List<Meal> meals = new ArrayList<>();

        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Meal meal = new Meal(
                        resultSet.getString("name"),
                        resultSet.getString("description")
                );
                meal.setId(resultSet.getInt("id"));
                meals.add(meal);
            }

        } catch (SQLException e) {
            System.out.println("Error selecting random meals: " + e.getMessage());
        }

        return meals;
    }
}
