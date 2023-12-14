package org.example.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBarbarian {

    @Test
    void attack_otherBarbarian_otherHpGetLow(){
        Barbarian b1 = new Barbarian("b1",100,50,50);
        Barbarian b2 = new Barbarian("b2",100,50,10);

        b1.attack(b2);
        assertEquals(100 - ((50 - 10) / 2),b2.getHp());
    }

    @Test
    void attack_DeadBarbarian_NotAttack(){
        Barbarian b1 = new Barbarian("b1",100,50,50);
        Barbarian b2 = new Barbarian("b2",0,50,10);

        b1.attack(b2);
        assertEquals(0,b2.getHp());
    }
}
