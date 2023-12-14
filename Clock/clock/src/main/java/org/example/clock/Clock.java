package org.example.clock;

public class Clock {
    // 12 hour standard
    private static int MAX_SECONDS = 12 * 60 * 60;
    private int seconds;

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
        return hours == 0 ? 12 : hours;
    }

    public void addSeconds(int seconds){
        int newSeconds = this.seconds + seconds;
        while(newSeconds < 0){
            newSeconds += MAX_SECONDS;
        }
        this.seconds = newSeconds % MAX_SECONDS;
    }

    public double getSecondHandAngle(){
        return getSeconds() * (360 / 60);
    }

    public double getMinuteHandAngle(){
        return Math.round((360.0 / (60 * 60)) * 100 * (seconds % 3600)) / 100.0;
    }

    public double getHourHandAngle(){
        return  Math.round((360.0 / MAX_SECONDS) * 100 * seconds) / 100.0;
    }


    public void tick(){
        addSeconds(1);
    }

    public void mount(){

    }
}
