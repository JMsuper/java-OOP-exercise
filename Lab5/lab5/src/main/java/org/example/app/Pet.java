package org.example.app;

public class Pet {
    private String name;
    private int offence;

    public Pet(String name, int offence){
        this.name = name;
        this.offence = offence;
    }

    public int getOffence() {
        return offence;
    }
}
