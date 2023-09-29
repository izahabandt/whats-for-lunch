package com.izahabandt;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
//        if (database.open()) {
//            List<Meal> mealsToAdd = new ArrayList<>();
//            mealsToAdd.add(new Meal("Asian Gnocchi", "Gnocchi with tofu and broccoli by Rozkoszny"));
//            mealsToAdd.add(new Meal("Eggplant Lasagne", "Lasagne with eggplant and ricotta cheese by Cookido"));
//            mealsToAdd.add(new Meal("Butter Chicken", "Butter chicken by Cookido"));
//            mealsToAdd.add(new Meal("Korean Tofu", "Rice with tofu and broccoli by Cookido"));
//            mealsToAdd.add(new Meal("Cream Cheese Crepes", "Fried crepes with cream cheese"));
//            mealsToAdd.add(new Meal("Quesadilla", "Quesadilla with tomato sauce, mushrooms and corn"));
//            mealsToAdd.add(new Meal("Gnocchi Salad", "Gnocchi with pesto, mozzarella and tomatoes"));
//            mealsToAdd.add(new Meal("Vegetable Salad", "Vegetable salad with red pepper, cucumber and feta cheese"));
//            mealsToAdd.add(new Meal("Spring Rolls", "Spring rolls with tofu, cucumber and pepper"));
//            mealsToAdd.add(new Meal("Classic Lunch", "Potatoes, cucumber salad and a veggie schnitzel"));
//            mealsToAdd.add(new Meal("Mascarpone Pasta", "Pasta with mascarpone cheese, dried tomatoes, spinach and optionally bacon"));

//            for (Meal meal : mealsToAdd) {
//                boolean success = database.addMeal(meal);
//
//                if (success) {
//                    System.out.println("Meal added successfully: " + meal.getName());
//                } else {
//                    System.out.println("Failed to add meal: " + meal.getName());
//                }
//            }

            List<Meal> weeklyMenu = database.getRandomMealsForWeek();

            if (!weeklyMenu.isEmpty()) {
                System.out.println("Here's your menu for the upcoming week:");
                for (int i = 0; i < weeklyMenu.size(); i++) {
                    Meal meal = weeklyMenu.get(i);
                    System.out.println("Meal " + (i + 1) + ": " + meal.getName());
                    System.out.println("Description: " + meal.getDescription());
                    System.out.println();
                }
            } else {
                System.out.println("No meals found in the database.");
            }

            database.close();
        } else {
            System.out.println("Unable to connect to the database.");
        }
    }
}