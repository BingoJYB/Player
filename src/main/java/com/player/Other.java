package com.player;

import com.player.api.Role;

public class Other extends Role {
    private String playerName;
    private int receivedMessageCount = 0;

    Other(String name) {
        this.playerName = name;
    }

    @Override
    public String receiveMessage(Role from, String message) throws Exception {
        if (++this.receivedMessageCount > 10) {
            throw new Exception("Message number exceeds!");
        }

        message += " " + this.receivedMessageCount;
        return this.sendMessage(from, message);
    }
}
