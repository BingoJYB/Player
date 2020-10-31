package com.player.logging;

import java.util.HashMap;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class Logging {
    private static HashMap<String, Logger> loggers = new HashMap<>();
    private static ConsoleHandler handler;

    static {
        handler = new ConsoleHandler();
        handler.setLevel(Level.FINE);
        handler.setFormatter(new Formatter() {
            @Override
            public String format(LogRecord record) {
                return String.format("%s%n", record.getMessage());
            }
        });
    }

    public static void log(String message, String className) {
        Logger logger;

        if (loggers.containsKey(className)) {
            logger = loggers.get(className);
        } else {
            logger = Logger.getLogger(className);
            logger.addHandler(handler);
            logger.setUseParentHandlers(false);
            loggers.put(className, logger);
        }

        logger.info(message);
    }
}
