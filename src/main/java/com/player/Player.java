package com.player;

import java.io.IOException;

import com.player.api.Role;
import com.player.logging.Logging;

/**
 * A factory to create initiator or non initiator player by the given name
 *
 */
public class Player {
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
