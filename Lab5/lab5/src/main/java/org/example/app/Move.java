package org.example.app;

public class Move {
    private final String name;
    private final int offence;
    public int maxSkillPoint;
    private int skillPoint;

    public Move(String name, int offence, int maxSkillPoint){
        this.name = name;
        this.offence = offence;
        this.maxSkillPoint = maxSkillPoint;
        this.skillPoint = maxSkillPoint;
    }

    public String getName() {
        return name;
    }

    public int getOffence() {
        return offence;
    }

    public int getSkillPoint() {
        return skillPoint;
    }

    public boolean canUse(){
        if (skillPoint <= 0){
            assert skillPoint == 0;
            return false;
        }
        return true;
    }

    public void usedOnce(){
        skillPoint--;
    }

    public void restOnce(){
        if (skillPoint != maxSkillPoint){
            skillPoint++;
        }
    }
}
