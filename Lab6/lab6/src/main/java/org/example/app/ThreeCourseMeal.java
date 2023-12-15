package org.example.app;

public class ThreeCourseMeal extends Course{

    @Override
    public boolean isValid() {
        return !appetizers.isEmpty() && !desserts.isEmpty() && !mainCourses.isEmpty();
    }
}
