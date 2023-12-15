package org.example.app;

public class HousePizza extends Pizza{
    public HousePizza(){
        super.maxAllTopping = 2;
    }
    @Override
    public boolean isValid() {
        return super.toppings.size() == 2;
    }
}
