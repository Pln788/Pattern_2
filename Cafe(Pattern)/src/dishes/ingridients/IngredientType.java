package dishes.ingridients;

public enum IngredientType {
    BEAN(1,"Фасоль"),
    BEEF_CHOP(2,"Говяжья котлета"),
    CHICKEN_CHOP(3, "Куриная котлета"),
    BEEF(4, "Говядина"),
    CHICKEN(5, "Курица"),
    CUCUMBER(6, "Огурец"),
    KETCHUP(7, "Кетчуп"),
    POTATO(8, "Картошка"),
    SALAD(9, "Салат"),
    TOMATO(10, "Помидор"),
    OLIVES(11, "Оливки"),
    CHEESE(12, "Сыр");

    private final int id;
    private final String ruName;

    IngredientType(int id, String ruName) {
        this.id = id;
        this.ruName = ruName;
    }

    public int getId() {
        return id;
    }

    public String getRuName() {
        return ruName;
    }
    public static IngredientType getById(int id) {
        return IngredientType.values()[id-1];
    }
}
