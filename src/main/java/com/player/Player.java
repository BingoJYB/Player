package com.player;

import com.player.api.Role;
import com.player.logging.Logging;

public class Player {
    public static Role createPlayer(String name) {
        Logging.log(name + " joins in the game.", Other.class.getName());

        switch (name) {
            case "initiator":
                return new Initiator();
            default:
                return new Other(name);
        }
    }
}
