package org.example.app;

public class DeathByDesserts extends Course{

    @Override
    public boolean isValid() {
        return appetizers.isEmpty() && !desserts.isEmpty() && mainCourses.isEmpty();
    }
}
