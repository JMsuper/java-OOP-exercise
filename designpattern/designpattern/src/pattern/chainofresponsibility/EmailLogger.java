package pattern.chainofresponsibility;

public class EmailLogger extends Logger{
    public EmailLogger(LogLevel[] levels) {
        super(levels);
    }

    @Override
    protected void log(String msg) {
        System.out.println("EmailLogger : " + msg);
    }
}
