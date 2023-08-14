package main_programm;

import dishes.builders.OrderBullder;
import dishes.builders.PizzaBuilder;
import dishes.dessert.Cake;
import dishes.drink.FruitFresh;
import dishes.ingridients.Ingredient;
import dishes.ingridients.IngredientType;
import dishes.second_dish.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Order order = new OrderBullder()
                .addDessert(new Cake())
                .addDrink(new FruitFresh())
                .build();
        Pizza pizza = makePizza();
        System.out.println(pizza);
    }

    public static Pizza makePizza() {
        PizzaBuilder pizzaBuilder = new PizzaBuilder();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Здраввстуйте!");
        System.out.println("Выберите основу для пиццы: 1 - тонкая, 2 обычная, 3 - толстая, 4 -закрытая.");

        String doughBase;
        try {
            String answer = reader.readLine();
            switch (answer) {
                case "1" -> {
                    doughBase = "thin";
                }
                case "3" -> {
                    doughBase = "lush";
                }
                case "4" -> {
                    doughBase = "closed";
                }
                default -> {
                    doughBase = "normal";
                }
            }
            pizzaBuilder.setDoughBase(doughBase);
        } catch (IOException e) {
            System.out.println("При выборе основы для пиццы возникла ошибка!");
        }

        try {
            System.out.println("Добавьте ингредиенты: ");
            System.out.println(Arrays.stream(IngredientType.values())
                                    .map(ingredientType -> ingredientType.getId() + " - " + ingredientType.getRuName())
                                    .collect(Collectors.joining(", ")));
            System.out.println("Введите \"хватит\" для завершения выбора ингредиентов.");
            String answer;
            while (!(answer = reader.readLine()).equals("хватит")) {
                Ingredient ingredient = new Ingredient(
                        IngredientType.getById(Integer.parseInt(answer)),
                        "our supplier",
                        LocalDateTime.now(),
                        LocalDateTime.MAX);
                pizzaBuilder.addIngredient(ingredient);
            }
        } catch (IOException e) {
            System.out.println("При добавлении ингредиентов возникла ошибка");
        }

        return pizzaBuilder.build();
    }
}
