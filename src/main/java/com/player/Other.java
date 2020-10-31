package com.player;

import com.player.api.Role;
import com.player.logging.Logging;

public class Other extends Role {
    private String name;
    private int receivedMessageCount = 0;

    Other(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String receiveMessage(Role from, String message) throws Exception {
        this.receivedMessageCount++;
        if (this.receivedMessageCount > 10) {
            throw new Exception("Message number exceeds!");
        }

        Logging.log(this.name + " receives a message from " + from.getName() + ": " + message, Other.class.getName());

        message += " " + this.receivedMessageCount;
        return this.sendMessage(from, message);
    }
}
