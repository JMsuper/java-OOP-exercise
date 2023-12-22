package pattern.builder;

import pattern.Runnable;

public class Run implements Runnable {
    public void run(){
        Employ employ = new EmployeeBuilder(1)
                .withAge(31)
                .withStaringYear(2020)
                .withName("Robert","Lee")
                .build();
    }
}
