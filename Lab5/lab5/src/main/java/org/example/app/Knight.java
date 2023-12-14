package org.example.app;

import java.util.HashMap;
import java.util.Map;

public class Knight extends Gladiator{

    private Pet pet;
    public Knight(String name, int hp, int offence, int defence) {
        super(name, hp, offence, defence);
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void attackTogether(Barbarian other){
        if(this.name.equals(other.name)) return;
        if (this.isAlive() && other.isAlive() && pet != null){
            int damage = ((this.offence + pet.getOffence() - other.getDefence()) / 2);
            if(damage < 1){
                damage = 1;
            }
            other.takeDamage(damage);
        }
    }
}
