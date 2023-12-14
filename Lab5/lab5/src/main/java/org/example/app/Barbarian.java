package org.example.app;

public class Barbarian {
    protected String name;
    protected final int maxHp;
    protected int hp;
    protected int offence;
    protected int defence;

    public Barbarian(String name, int hp, int offence, int defence){
        this.name = name;
        this.maxHp = hp;
        this.hp = hp;
        this.offence = offence;
        this.defence = defence;
    }

    public int getHp() {return hp;}

    public int getDefence() {
        return defence;
    }

    public void takeDamage(int damage){
        int newHp = hp - damage;
        hp = newHp < 0 ? 0 : newHp;
    }


    public void print(){
        System.out.println("************ ADD USER ************");
        System.out.printf("User Type : %s %s",this.getClass().getName(),System.lineSeparator());
        System.out.printf("Name : %s %s",name,System.lineSeparator());
        System.out.printf("HP : %s %s",hp,System.lineSeparator());
        System.out.printf("Offence : %s %s",offence,System.lineSeparator());
        System.out.printf("Defence : %s %s",defence,System.lineSeparator());
        System.out.println("***********************************");
    }

    public boolean isAlive(){
        if(hp <= 0){
            assert hp == 0;
            return false;
        }
        return true;
    }

    public void attack(Barbarian other){
        if(this.name.equals(other.name)) return;
        if (this.isAlive() && other.isAlive()){
            int damage = ((this.offence - other.getDefence()) / 2);
            if(damage < 1){
                damage = 1;
            }
            other.takeDamage(damage);
        }
    }
}
