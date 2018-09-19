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
    private static int clientId = 0;
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

        try {
            ServerSocket serverSocket = new ServerSocket(port);

            while(bRun) {
                System.out.println("Server waiting for clients on port " + port + ".");

                Socket socket = serverSocket.accept();

                if (!bRun)
                    break;
                
                ClientThread clientThread = new ClientThread(clientId++, socket);
            }

            // Stop the server
            try {
                for (int i: clientMap.keySet()) {
                    ClientThread clientThread = clientMap.get(i);

                    try {
                        // clientThread.sInput.close();
                        // clientThread.sOutput.close();
                        clientThread.socket.close();
                    }
                    catch(Exception e) {
                        System.out.println("Exception on closing connection with client " + i +":" + e);
                    }
                }
            } catch(Exception e) {
                System.out.println("Exception on closing the server:" + e);
            }
        }
        catch (IOException e) {
            System.out.println("Exception on creating socket:" + e + "\n");
        }
    }

    /**
     * Stop the server.
     */
    public void stop() {
        bRun = false;

        try {
            // use myself to break the accept() waiting
            new Socket("localhost", port);
        }
        catch (Exception e) {
            System.out.println("Exception on stoping the server: " + e);
        }
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
    }
}
