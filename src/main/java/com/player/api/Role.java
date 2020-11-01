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

    public abstract String receiveMessage() throws IOException;

    public abstract String sendMessage(String message) throws IOException;

    public abstract void start() throws IOException;

    public abstract void stop() throws IOException;
}
