package com.player;

import com.player.api.Role;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Role player1 = Player.createPlayer("initiator");
        Role player2 = Player.createPlayer("receiver");

        System.out.println(player1.sendMessage(player2, "hello player"));
        System.out.println(player1.sendMessage(player2, "hello player"));
        System.out.println(player1.sendMessage(player2, "hello player"));
    }
}
