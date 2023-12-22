package pattern.chainofresponsibility;

public class ConsoleLogger extends Logger{
    public ConsoleLogger(LogLevel[] levels) {
        super(levels);
    }

    @Override
    protected void log(String msg) {
        System.out.println("ConsoleLogger : " + msg);
    }
}
