package org.example.clock;

public class DigitalClock extends Clock{
    // 1. 오전 / 오후 구분 및 출력
    public boolean isBeforeMidday(){
        return super.seconds / (60 * 60) <= 12;
    }


    // 2. 시간 맞추는 방식
    public void setIsBeforeMidday(boolean isAm){
        // super.seconds의 값을 AM 시간대 혹은 PM 시간대로 변경
        if(!isAm){
            super.seconds = (super.seconds + 12 * 60 * 60) % MAX_SECONDS;
        }
    }

    public void setHours(int hours){
        // super.seconds에서 시에 해당하는 부분을 hours로 변경
        super.seconds += clamp(hours,0,12) * 3600;
    }

    public void setMinutes(int minutes){
        // super.seconds에서 분에 해당하는 부분을 minutes로 변경
        super.seconds += clamp(minutes,0,59) * 60;
    }

    public void setSeconds(int seconds){
        // super.seconds에서 분에 해당하는 부분을 seconds로 변경
        super.seconds += clamp(seconds,0,59);
    }

    public void setTime(int hours, int minutes, int seconds, boolean isAm){
        // 아래 순서가 변경되면 안됨! -> 후속 호출 메서드의 영향을 줌!
        super.seconds = 0;
        setHours(hours);
        setMinutes(minutes);
        setSeconds(seconds);
        setIsBeforeMidday(isAm);
    }

    private int clamp(int input, int min, int max){
        return Math.min(Math.max(input,min),max);
    }

    // 3. 7 세그먼트 디스플레이를 이용한 시간 출력

}
