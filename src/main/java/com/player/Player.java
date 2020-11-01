package com.player;

import java.io.IOException;

import com.player.api.Role;
import com.player.logging.Logging;

/**
 * A factory to create initiator or non initiator player by the given name
 *
 */
public class Player {
    /**
     * Player factory
     * 
     * @param name a player name
     * @param ip   a player ip address
     * @param port a player port number
     * @return returns a player role
     */
    public static Role createPlayer(String name, String ip, int port) throws IOException {
        Logging.log(name + " joins in the game.", Player.class.getName());

        switch (name) {
            case "initiator":
                return new Initiator(ip, port);
            default:
                return new Other(name, port);
        }
    }
}
