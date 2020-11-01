package com.player;

import com.player.api.Role;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for Player Game.
 */
public class AppTest {
    private Role player1;
    private Role player2;

    /**
     * Create two players, player1 and player2
     */
    @Before
    public void setUp() {
        player1 = Player.createPlayer("initiator");
        player2 = Player.createPlayer("other player");
    }

    /**
     * Message received by initiator should contain what initiator sends
     */
    @Test
    public void shouldContainSentMessage() {
        String result = "";
        String message = "foo bar";
        try {
            result = player1.sendMessage(player2, message);
            assertTrue(result.contains("foo bar"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Message counter should increase each time initiator sends a message
     */
    @Test
    public void messageCounterShouldIncrease() {
        String result = "";
        String message = "foo bar";
        try {
            result = player1.sendMessage(player2, message);
            assertEquals(result, "foo bar 1");
            result = player1.sendMessage(player2, message);
            assertEquals(result, "foo bar 2");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * If message counter exceeds 10, an exception occurs
     */
    @Test
    public void shouldTerminateWhenMessageCounterExceedTen() {
        String message = "foo bar";

        try {
            for (int i = 0; i < 100; i++) {
                player1.sendMessage(player2, message);
            }
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Message number exceeds!");
        }
    }
}
