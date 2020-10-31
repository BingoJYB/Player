package com.player.api;

public abstract class Role {
    public abstract String receiveMessage(Role from, String message) throws Exception;

    public String sendMessage(Role to, String message) throws Exception {
        return to.receiveMessage(this, message);
    };
}
