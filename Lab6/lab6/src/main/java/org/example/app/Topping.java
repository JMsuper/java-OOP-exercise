package org.example.app;

public enum Topping {
    // CHEESE
    MOZZARELLA(ToppingType.CHEESE),
    FETA_CHEESE(ToppingType.CHEESE),
    CHEDDAR_CHEESE(ToppingType.CHEESE),

    // VEGGIE
    BLACK_OLIVES(ToppingType.VEGGIE),
    RED_ONIONS(ToppingType.VEGGIE),
    GREEN_PEPPERS(ToppingType.VEGGIE),


    // MEAT
    CHICKEN(ToppingType.MEAT),
    SAUSAGES(ToppingType.MEAT),
    PEPERONI(ToppingType.MEAT),
    BACON(ToppingType.MEAT);

    private final ToppingType type;

    Topping(ToppingType toppingType){
        this.type = toppingType;
    }

    public ToppingType getType() {
        return type;
    }
}
