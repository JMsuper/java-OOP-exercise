package org.example.clock;

public class Clock {
    // 12 hour standard
    protected static int MAX_SECONDS = 24 * 60 * 60;
    protected int seconds;

    public Clock(){
        this.seconds = 0;
    }

    public int getSeconds(){
        return  this.seconds % 60;
    }

    public int getMinutes(){
        return (this.seconds / 60) % 60;
    }

    public int getHours(){
        int hours = this.seconds / 3600;
        hours = hours % 12;
        return hours == 0 ? 12 : hours;
    }

    public void tick(){
        int newSeconds = this.seconds + 1;
        this.seconds = newSeconds % MAX_SECONDS;
    }

    public void addSeconds(int seconds){
        int newSeconds = this.seconds + seconds;
        while(newSeconds < 0){
            newSeconds += MAX_SECONDS;
        }
        this.seconds = newSeconds % MAX_SECONDS;
    }

    public void mount(){

    }
}
