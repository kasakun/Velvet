package org.velvet;

import java.io.*;
import java.net.*;

class ClientThread extends Thread {

    Socket socket;
    ObjectInputStream inputStream;
    ObjectOutputStream outputStream;

    private int id;
    String username;
    // Message message;
    String date;

    ClientThread(int clientId, Socket socket) {
        this.id = clientId;
        this.socket = socket;

        try {
            // create output first
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream  = new ObjectInputStream(socket.getInputStream());
            // read the username
            username = (String) inputStream.readObject();
            System.out.println(username + " just connected.");
        }
        catch (IOException e) {
            System.out.println("Exception creating new connection: " + e);
            return;
        }
        catch (Exception e) {
            System.out.println("Unexpected excetption on creating connections: " + e);
        }
    } 
}