package org.example;

import java.util.Objects;

public class User {
    // member variable
    private final String name;


    // Constructor
    public User(String name){
        this.name = name;
    }


    // Method
    @Override
    public boolean equals(Object object){
        if ((object == null) || (object.getClass() != User.class)){
            return false;
        }
        User otherUser = (User) object;
        return this.name.equals(otherUser.name);
    }

    @Override
    public int hashCode(){
        return Objects.hash(name);
    }
}
