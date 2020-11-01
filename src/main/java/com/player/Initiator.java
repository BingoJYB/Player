package com.player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import com.player.api.Role;
import com.player.logging.Logging;

/**
 * A class represents a player which is an initiator
 *
 */
public class Initiator extends Role {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private String name = "initiator";

    Initiator(String ip, int port) throws UnknownHostException, IOException {
        this.clientSocket = new Socket(ip, port);
        this.out = new PrintWriter(this.clientSocket.getOutputStream(), true);
        this.in = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void start() throws UnknownHostException, IOException {
        for (int i = 0; i < 10; i++) {
            String message = this.sendMessage("hello player");

            Logging.log(this.name + " sends a message: " + message, Initiator.class.getName());

            message = this.receiveMessage();

            Logging.log(this.name + " receives a message: " + message, Initiator.class.getName());
        }
    }

    @Override
    public String receiveMessage() throws IOException {
        return this.in.readLine();
    }

    @Override
    public String sendMessage(String message) throws IOException {
        this.out.println(message);
        return message;
    }

    @Override
    public void stop() throws IOException {
        this.in.close();
        this.out.close();
        this.clientSocket.close();
    }
}
