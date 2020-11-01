package com.player;

import java.io.IOException;

import com.player.api.Role;
import com.player.logging.Logging;

/**
 * A game in which an initiator sends a message and the other player sends back
 * the received message concatenating with message counter
 *
 */
public class App {
    public static void main(String[] args) throws IOException {
        /**
         * Player name
         */
        String name = null;

        try {
            name = args[0];
        } catch (IndexOutOfBoundsException e) {
            Logging.log("Invalid player name", App.class.getName());
            System.exit(1);
        }

        Role player = Player.createPlayer(name, "127.0.0.1", 5000);

        try {
            player.start();
        } catch (Exception e) {
            player.stop();
        } finally {
            Logging.log("Game Over!", App.class.getName());
        }
    }
}
