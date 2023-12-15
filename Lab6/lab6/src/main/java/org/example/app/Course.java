package org.example.app;

import java.util.Arrays;
import java.util.HashSet;

public abstract class Course  extends Menu{
    protected HashSet<Appetizer> appetizers;
    protected HashSet<Dessert> desserts;
    protected HashSet<MainCourse> mainCourses;

    protected Course(){
        appetizers = new HashSet<>();
        desserts = new HashSet<>();
        mainCourses = new HashSet<>();
    }

    public void setAppetizer(Appetizer appetizer) {
        this.appetizers.add(appetizer);
    }

    public void setAppetizers(Appetizer... appetizers) {
        this.appetizers.addAll(Arrays.asList(appetizers));
    }

    public void setDessert(Dessert dessert) {
        this.desserts.add(dessert);
    }

    public void setDesserts(Dessert... desserts) {
        this.desserts.addAll(Arrays.asList(desserts));
    }

    public void setMainCourses(MainCourse mainCourses) {
        this.mainCourses.add(mainCourses);
    }
}
