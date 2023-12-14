package org.example.clock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClock {
    Clock clock;

    @BeforeEach
    void init(){
        clock = new Clock();
    }

    @Test
    void getSeconds_60overSecond_60underSecond(){
        clock.addSeconds( 61);
        assertEquals(1,clock.getSeconds());

        clock.addSeconds(3602);
        assertEquals(3,clock.getSeconds());
    }

    @Test
    void getMinute_61Seconds_1Minute(){
        clock.addSeconds(61);
        assertEquals(1,clock.getMinutes());
    }

    @Test
    void getHour(){
        // 01:00:01
        clock.addSeconds(3601);
        assertEquals(1,clock.getHours());

        // 17:00:01
        clock = new Clock();
        clock.addSeconds(61200);
        assertEquals(5,clock.getHours());

        // 0 seconds
        clock = new Clock();
        assertEquals(12,clock.getHours());
    }

    @Test
    void addSeconds_minusSeconds_plusSeconds(){
        clock.addSeconds(-1);
        assertEquals(59,clock.getSeconds());

        clock.addSeconds(-43200);
        assertEquals(59,clock.getSeconds());
    }

    @Test
    void getSecondHandAngle(){
        clock.addSeconds(1);
        assertEquals(6,clock.getSecondHandAngle());

        clock.addSeconds(61);
        assertEquals(12,clock.getSecondHandAngle());
    }

    @Test
    void getMinuteHandAngle(){
        clock.addSeconds(1);
        assertEquals(0.1,clock.getMinuteHandAngle());

        clock.addSeconds(3601);
        assertEquals(0.2,clock.getMinuteHandAngle());
    }

    @Test
    void getHourHandAngle(){
        clock.addSeconds(1);
        assertEquals(0.01,clock.getHourHandAngle());

        clock.addSeconds(21599);
        assertEquals(180.0,clock.getHourHandAngle());

        clock.addSeconds(21601);
        assertEquals(0.01,clock.getHourHandAngle());
    }

}
