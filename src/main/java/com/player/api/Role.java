package com.player.api;

import java.io.IOException;

/**
 * An abstract class contains methods used by players
 * 
 */
public abstract class Role {
    /**
     * @return the player name
     */
    public abstract String getName();

    /**
     * Receive message from another player
     * 
     * @return returns the received message
     */
    public abstract String receiveMessage() throws IOException;

    /**
     * Send message to another player
     * 
     * @return returns the sent message
     */
    public abstract String sendMessage(String message) throws IOException;

    /**
     * Start one player process
     * 
     */
    public abstract void start() throws IOException;

    /**
     * Stop one player process
     * 
     */
    public abstract void stop() throws IOException;
}
