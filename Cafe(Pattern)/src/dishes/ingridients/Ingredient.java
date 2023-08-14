package dishes.ingridients;

import java.time.LocalDateTime;

public class Ingredient {
        private final IngredientType type;
        private final String supplier;
        private final LocalDateTime productionDate;
        private final LocalDateTime bestBeforeDate;

    public Ingredient(IngredientType type, String supplier, LocalDateTime productionDate, LocalDateTime bestBeforeDate) {
        this.type = type;
        this.supplier = supplier;
        this.productionDate = productionDate;
        this.bestBeforeDate = bestBeforeDate;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "type=" + type +
                ",\n supplier='" + supplier + '\'' +
                ",\n productionDate=" + productionDate +
                ",\n bestBeforeDate=" + bestBeforeDate +
                "\n}";
    }
}
