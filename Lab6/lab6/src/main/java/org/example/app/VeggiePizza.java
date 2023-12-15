package org.example.app;

public class VeggiePizza extends Pizza{

    @Override
    public boolean isValid() {
        return super.getCountByToppingType(ToppingType.CHEESE) >= 2;
    }
}
