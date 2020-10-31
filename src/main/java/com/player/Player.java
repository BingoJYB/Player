package com.player;

import com.player.api.Role;

public class Player {
    private String playerName;

    public static Role createPlayer(String name) {
        switch (name) {
            case "initiator":
                return new Initiator();
            default:
                return new Other(name);
        }
    }
}
