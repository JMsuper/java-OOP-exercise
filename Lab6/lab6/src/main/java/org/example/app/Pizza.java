package org.example.app;

import java.util.ArrayList;

public abstract class Pizza extends Menu{
    static final int DEFAULT_MAX_TOPPING = 10;
    protected ArrayList<Topping> toppings;

    protected boolean canToppingDuplicated;
    protected int maxAllTopping;
    protected int meatMaxTopping;
    protected int veggieMaxTopping;
    protected int cheeseMaxTopping;

    protected Pizza(){
        toppings = new ArrayList<>();
        canToppingDuplicated = true;
        maxAllTopping = DEFAULT_MAX_TOPPING;
        meatMaxTopping = DEFAULT_MAX_TOPPING;
        veggieMaxTopping = DEFAULT_MAX_TOPPING;
        cheeseMaxTopping = DEFAULT_MAX_TOPPING;
    }

    public boolean addTopping(Topping topping){
        ToppingType type = topping.getType();
        if(toppings.size() == maxAllTopping ||
                getMaxToppingType(type) == getCountByToppingType(type)){
            return false;
        }
        if(!canToppingDuplicated && toppings.contains(topping)){
            return false;
        }
        toppings.add(topping);
        return true;
    }

    public boolean removeTopping(Topping topping){
        return toppings.remove(topping);
    }


    protected int getMaxToppingType(ToppingType type){
        switch (type){
            case CHEESE:
                return this.cheeseMaxTopping;
            case VEGGIE:
                return this.veggieMaxTopping;
            case MEAT:
                return this.meatMaxTopping;
            default:
                assert false : "not allowed topping type";
        }
        return 0;
    }

    protected int getCountByToppingType(ToppingType type){
        return (int) this.toppings.stream()
                .filter(item -> item.getType().equals(type)).count();
    }

    public boolean addBacon(){
        return addTopping(Topping.BACON);
    }

    public boolean removeBacon(){
        return removeTopping(Topping.BACON);
    }

    public boolean addPeperoni(){
        return addTopping(Topping.PEPERONI);
    }

    public boolean addSausages(){
        return addTopping(Topping.SAUSAGES);
    }

    public boolean removeSausages(){
        return removeTopping(Topping.SAUSAGES);
    }

    public boolean addGreenPeppers(){
        return addTopping(Topping.GREEN_PEPPERS);
    }

    public boolean removeGreenPeppers(){
        return removeTopping(Topping.GREEN_PEPPERS);
    }

    public boolean addCheddarCheese(){
        return addTopping(Topping.CHEDDAR_CHEESE);
    }

    public boolean removeCheddarCheese(){
        return removeTopping(Topping.CHEDDAR_CHEESE);
    }

    public boolean addFetaCheese(){
        return addTopping(Topping.FETA_CHEESE);
    }

    public boolean addMozzarellaCheese(){
        return addTopping(Topping.MOZZARELLA);
    }

}
