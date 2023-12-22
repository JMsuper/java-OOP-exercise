package pattern.chainofresponsibility;

import java.util.Arrays;
import java.util.EnumSet;

public abstract class Logger {
    private EnumSet<LogLevel> logLevels;
    private Logger next;

    public Logger(LogLevel[] levels){
        this.logLevels = EnumSet.copyOf(Arrays.asList(levels));
    }

    public void setNext(Logger next){
        this.next = next;
    }

    public final void message(String msg, LogLevel severity){
        if(logLevels.contains(severity)){
            log(msg);
        } else if (this.next != null) {
            this.next.message(msg, severity);
        }
    }

    protected abstract void log(String msg);
}
