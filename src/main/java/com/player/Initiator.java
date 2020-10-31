package com.player;

import com.player.api.Role;
import com.player.logging.Logging;

public class Initiator extends Role {
    private String name = "initiator";

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String receiveMessage(Role from, String message) {
        Logging.log(this.name + " receives a message from " + from.getName() + ": " + message,
                Initiator.class.getName());

        return message;
    }
}
