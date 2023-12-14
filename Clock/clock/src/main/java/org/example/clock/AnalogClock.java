package org.example.clock;

public class AnalogClock extends Clock{

    public double getSecondHandAngle(){
        return getSeconds() * (360 / 60);
    }

    public double getMinuteHandAngle(){
        return Math.round((360.0 / (60 * 60)) * 100 * (seconds % 3600)) / 100.0;
    }

    public double getHourHandAngle(){
        return  Math.round((360.0 / (12 * 60 * 60)) * 100 * seconds) / 100.0;
    }
}
