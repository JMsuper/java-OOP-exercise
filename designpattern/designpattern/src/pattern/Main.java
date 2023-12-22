package pattern;


import pattern.chainofresponsibility.Run;

public class Main {
    public static void main(String[] args) {
        Runnable runnable = new Run();
        runnable.run();
    }
}