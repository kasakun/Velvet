package org.velvet;

import java.io.*;
import java.net.*;

class ClientThread extends Thread {
    
    Socket scoket;

    private int id;

    ClientThread(int clientId) {
        id = clientId;
    } 
}