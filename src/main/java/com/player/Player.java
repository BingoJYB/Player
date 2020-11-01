package com.player;

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
     * @return returns a player role
     */
    public static Role createPlayer(String name) {
        Logging.log(name + " joins in the game.", Player.class.getName());

        switch (name) {
            case "initiator":
                return new Initiator();
            default:
                return new Other(name);
        }
    }
}
