package dishes.builders;

import  dishes.types.*;
import main_programm.Order;

public class OrderBullder {
    private Snack snack;
    private FirstDish firstDish;
    private SecondDish secondDish;
    private Dessert dessert;
    private Drink drink;

    public OrderBullder addSnack (Snack snack) {
        this.snack = snack;
        return this;
    }

    public OrderBullder addFirstDish (FirstDish firstDish) {
        this.firstDish = firstDish;
        return this;
    }

    public OrderBullder addSecondDish (SecondDish secondDish) {
        this.secondDish = secondDish;
        return this;
    }

    public OrderBullder addDessert (Dessert dessert) {
        this.dessert = dessert;
        return this;
    }

    public OrderBullder addDrink (Drink drink) {
        this.drink = drink;
        return this;
    }

    public Order build() {
        if (snack == null && firstDish == null && secondDish == null && dessert == null && drink == null) {
            throw new RuntimeException("Попытка создания пустого заказа!");
        }
        return new Order(snack, firstDish, secondDish, dessert, drink);
    }
}
