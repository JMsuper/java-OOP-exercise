package org.example.app;

public class MeatLoverPizza extends Pizza{

    public MeatLoverPizza(){
        super.canToppingDuplicated = false;
        super.veggieMaxTopping = 1;
    }

    @Override
    public boolean isValid() {
        return super.getCountByToppingType(ToppingType.VEGGIE) == 1;
    }
}
