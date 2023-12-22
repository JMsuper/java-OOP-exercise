package pattern.chainofresponsibility;

import pattern.Runnable;

public class Run implements Runnable {
    @Override
    public void run() {
        Logger logger = new ConsoleLogger(new LogLevel[]{LogLevel.DEBUG,LogLevel.INFO});
        logger.setNext(new EmailLogger(new LogLevel[]{LogLevel.ERROR,LogLevel.WARNING}));

        logger.message("DEBUG log msg", LogLevel.DEBUG);
        logger.message("ERROR log msg", LogLevel.ERROR);
        logger.message("INFO log msg", LogLevel.INFO);
        logger.message("WARNING log msg", LogLevel.WARNING);
    }
}
