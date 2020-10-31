package com.player;

import com.player.api.Role;

public class Other extends Role {
    private String playerName;
    private int receivedMessageCount = 0;

    Other(String name) {
        this.playerName = name;
    }

    @Override
    public String receiveMessage(Role from, String message) {
        this.receivedMessageCount++;
        message += " " + this.receivedMessageCount;
        return this.sendMessage(from, message);
    }
}
