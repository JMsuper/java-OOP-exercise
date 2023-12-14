package org.example.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGladiator {

    @Test
    void attack_withMove_otherHpGetLow(){
        Gladiator theGladiator = new Gladiator("me",100,20,1);
        Gladiator otherGladiator = new Gladiator("other",100,20,10);

        Move theMove = new Move("move",10,5);
        theGladiator.addMove(theMove);
        theGladiator.attack("move",otherGladiator);

        assertEquals(100 - ((20 / 10) * 10)/2,otherGladiator.getHp());
    }

    @Test
    void rest(){
        Gladiator theGladiator = new Gladiator("me",100,20,1);
        Gladiator otherGladiator = new Gladiator("other",100,20,10);

        Move theMove = new Move("move",10,5);
        theGladiator.addMove(theMove);
        theGladiator.attack("move",otherGladiator);
        theGladiator.attack("move",otherGladiator);

        theGladiator.rest();
        otherGladiator.rest();
        assertEquals(90, otherGladiator.getHp());
        assertEquals(4,theMove.getSkillPoint());
    }
}
