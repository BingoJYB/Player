package com.player;

import com.player.api.Role;
import com.player.logging.Logging;

/**
 * Player game
 *
 */
public class App {
    public static void main(String[] args) {
        Role player1 = Player.createPlayer("initiator");
        Role player2 = Player.createPlayer("other player");

        try {
            while (true) {
                player1.sendMessage(player2, "hello player");
            }
        } catch (Exception e) {
            Logging.log("Game Over!", App.class.getName());
        }
    }
}
