package com.player;

import com.player.api.Role;
import com.player.logging.Logging;

/**
 * A class represents a player which is not an initiator
 *
 */
public class Other extends Role {
    /**
     * Player name
     */
    private final String name;
    /**
     * Received message counter
     */
    private int receivedMessageCount = 0;

    /**
     * Create a new player with the provided name
     * 
     * @param name
     */
    Other(String name) {
        this.name = name;
    }

    /**
     * @return the player name
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Receives a message and if the number of messages received exceeds 10, throws
     * an exception
     * 
     * @param from    the player sends the message
     * @param message the received message
     * @return returns message concatenated with the message counter that this
     *         player sent
     */
    @Override
    public String receiveMessage(Role from, String message) throws Exception {
        this.receivedMessageCount++;
        if (this.receivedMessageCount > 10) {
            throw new Exception("Message number exceeds!");
        }

        Logging.log(this.name + " receives a message from " + from.getName() + ": " + message, Other.class.getName());

        message += " " + this.receivedMessageCount;
        return this.sendMessage(from, message);
    }
}
