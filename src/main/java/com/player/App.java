package com.player;

import com.player.api.Role;

/**
 * Player game
 *
 */
public class App {
    public static void main(String[] args) {
        Role player1 = Player.createPlayer("initiator");
        Role player2 = Player.createPlayer("receiver");

        try {
            while (true) {
                System.out.println(player1.sendMessage(player2, "hello player"));
            }
        } catch (Exception e) {
            System.out.println("Game finished!");
        }
    }
}
