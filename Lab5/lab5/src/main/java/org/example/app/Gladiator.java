package org.example.app;

import java.util.HashMap;
import java.util.Map;

public class Gladiator extends Barbarian{
    static final int MAX_MOVE_COUNT = 4;

    private Map<String, Move> moveMap;
    public Gladiator(String name, int hp, int offence, int defence) {
        super(name, hp, offence, defence);
        moveMap = new HashMap<>();
    }

    public boolean addMove(Move move){
        if(move != null && !moveMap.containsKey(move.getName()) && moveMap.size() < MAX_MOVE_COUNT){
            moveMap.put(move.getName(),move);
            return true;
        }
        return false;
    }

    public boolean removeMove(String moveName){
        return moveMap.remove(moveName) != null;
    }

    public void attack(String moveName, Barbarian other){
        if (this.name.equals(other.name)){
            return;
        }
        if(!moveMap.containsKey(moveName)) {
            return;
        }

        Move theMove = moveMap.get(moveName);

        if(this.isAlive() && other.isAlive() && theMove.canUse()){
            int damage = (int)(((double)this.offence / other.defence) * theMove.getOffence()) / 2;
            if(damage < 1){
                damage = 1;
            }
            other.takeDamage(damage);
            theMove.usedOnce();
        }
    }

    public void rest(){
        if(this.isAlive()){
            this.hp = Math.min(this.hp + 10, this.maxHp);
            moveMap.forEach((name,theMove) -> theMove.restOnce());
        }
    }
}
