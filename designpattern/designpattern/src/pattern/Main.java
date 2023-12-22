package pattern;


import pattern.builder.example.documentation.Run;

public class Main {
    public static void main(String[] args) {
        Runnable runnable = new Run();
        runnable.run();
    }
}