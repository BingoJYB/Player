package com.player.api;

public abstract class Role {
    public abstract String receiveMessage(Role from, String message);

    public String sendMessage(Role to, String message) {
        return to.receiveMessage(this, message);
    };
}
