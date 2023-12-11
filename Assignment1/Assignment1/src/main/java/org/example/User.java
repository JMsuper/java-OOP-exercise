package org.example;

import java.util.Objects;

public class User {
    private String name;
    public User(String name){
        this.name = name;
    }

    @Override
    public boolean equals(Object object){
        if (object.getClass() != User.class){
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
