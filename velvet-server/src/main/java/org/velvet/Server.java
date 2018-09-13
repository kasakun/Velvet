package org.velvet;

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * The Server class
 *
 */
public class Server
{
    // Unique Id for each log in client
    private static int clientId;
    // Bind clientId to client thread
    private static HashMap<Integer, ClientThread> clientMap;
    // DateTime
    private static SimpleDateFormat date;
    // Port number
    private static int port;
    // Flag to run the server
    private static boolean bRun;

    /**
     * Constructor
     * 
     * @param port
     */
    public Server(int portNumber) {
        this.port = portNumber;
        this.date = new SimpleDateFormat("HH:mm:ss");
        this.clientMap = new HashMap<>();
    }

    /**
     * Start the server.
     */
    public void start() {
        bRun = true;
    }

    /**
     * Stop the server.
     */
    public void stop() {
        bRun = false;
    }

    /*
     * Main method of ther server
     */
    public static void main( String[] args )
    {
        int portNumber = 5000;
        ClientThread clientThead;
        
        Server server = new Server(portNumber);

        server.start();
        
        while(bRun) {
            System.out.println("Server:Listen");
        }
    }
}
