package org.example.app;

public class FreeSoulPizza extends Pizza{

    public FreeSoulPizza(){
        super.cheeseMaxTopping = 1;
        super.veggieMaxTopping = 2;
        super.meatMaxTopping = 2;
    }

    @Override
    public boolean isValid() {
        return super.getCountByToppingType(ToppingType.CHEESE) == 1 &&
                super.getCountByToppingType(ToppingType.MEAT) >= 1 &&
                super.getCountByToppingType(ToppingType.VEGGIE) >= 1;
    }
}
