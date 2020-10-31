package com.player.logging;

import java.util.HashMap;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/**
 * Logging helper class
 *
 */
public class Logging {
    /**
     * A hashmap stores logger for each class
     */
    private static HashMap<String, Logger> loggers = new HashMap<>();
    /**
     * A Logger console handler used by all loggers
     */
    private static ConsoleHandler handler;

    /**
     * Set up a console handler used by all loggers
     */
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

        /**
         * Reuse a logger or create a new one if not existing
         */
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
