package pattern.chainofresponsibility;

public enum LogLevel {
    INFO, DEBUG, WARNING, ERROR;
    public static LogLevel[] all(){
        return values();
    }
}
