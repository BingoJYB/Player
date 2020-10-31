package com.player;

import com.player.api.Role;
import com.player.logging.Logging;

/**
 * A class represents a player which is an initiator
 *
 */
public class Initiator extends Role {
    /**
     * Player name which is always "initiator"
     */
    private final String name = "initiator";

    /**
     * @return the player name
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Receives a message from other not initiator players
     * 
     * @param from    the player sends the message
     * @param message the received message
     * @return returns message concatenated with the message counter that other
     *         player sent
     */
    @Override
    public String receiveMessage(Role from, String message) {
        Logging.log(this.name + " receives a message from " + from.getName() + ": " + message,
                Initiator.class.getName());

        return message;
    }
}
