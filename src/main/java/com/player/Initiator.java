package com.player;

import com.player.api.Role;

public class Initiator extends Role {
    private String playerName = "initiator";

    @Override
    public String receiveMessage(Role from, String message) {
        return message;
    }
}
