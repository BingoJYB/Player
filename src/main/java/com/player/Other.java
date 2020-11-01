package com.player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import com.player.api.Role;
import com.player.logging.Logging;

/**
 * A class represents a player which is not an initiator
 *
 */
public class Other extends Role {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    /**
     * Received message number
     */
    private int receivedMessageCounter = 0;
    /**
     * Player name
     */
    private final String name;

    Other(String name, int port) throws IOException {
        this.name = name;
        this.serverSocket = new ServerSocket(port);
        this.clientSocket = this.serverSocket.accept();
        this.out = new PrintWriter(this.clientSocket.getOutputStream(), true);
        this.in = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
    }

    /**
     * @return the player name
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Start the non initiator process. Stop the game after getting 10 messages
     */
    @Override
    public void start() throws IOException {
        while (true) {
            String message = this.receiveMessage();

            if (this.receivedMessageCounter > 10) {
                break;
            }

            Logging.log(this.name + " receives a message: " + message, Other.class.getName());

            message = this.sendMessage(message);

            Logging.log(this.name + " sends a message: " + message, Other.class.getName());
        }
    }

    /**
     * Receive message from another player
     * 
     * @return returns received message
     */
    @Override
    public String receiveMessage() throws IOException {
        this.receivedMessageCounter++;
        return this.in.readLine();
    }

    /**
     * Send message to another player
     * 
     * @param message the message sent to the other player
     * @return returns the sent message concatenated with the message counter that
     *         the other player sent
     */
    @Override
    public String sendMessage(String message) throws IOException {
        message += " " + this.receivedMessageCounter;
        this.out.println(message);
        return message;
    }

    /**
     * Stop initiator process by closing all the connections
     * 
     */
    @Override
    public void stop() throws IOException {
        this.in.close();
        this.out.close();
        this.clientSocket.close();
        this.serverSocket.close();
    }
}
