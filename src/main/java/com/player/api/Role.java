package com.player.api;

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
     * Receives a message from other player.
     * 
     * @param from    the player sends the message
     * @param message the received message
     * @return returns the message the initiator receives
     */
    public abstract String receiveMessage(Role from, String message) throws Exception;

    /**
     * Sends a message to another player
     * 
     * @param to      the player receives the message
     * @param message the sent message
     * @return returns the message the initiator receives
     */
    public String sendMessage(Role to, String message) throws Exception {
        return to.receiveMessage(this, message);
    };
}
