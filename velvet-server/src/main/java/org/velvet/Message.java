package org.velvet;

import java.io.*;
import java.text.SimpleDateFormat;

/**
 * Currently support 1 to 1 message and broadcast message.
 * Only support text.
 * 
 * @version 1.0
 */
public class Message implements Serializable {

    // @version 1.0
    protected static final long serialVersionUID = 1L;
    // Message type
    private int type;
    // The target client username
    private int destUserName;
    // The time message sent
    private SimpleDateFormat sentDate;
    // The content
    private String content;
    // Message type
    static final int LOGOUT = 0, MESSAGE = 1;
    
    // constructor
    Message(int type, String content) {
        this.type = type;
        this.content = content;
        this.sentDate = new SimpleDateFormat("HH:mm:ss");
    }
    
    /**
     * Get the type of the message.
     *
     * @return type of the message
     */
    int getType() {
        return type;
    }

    /**
     * Get the content of the message.
     * @return
     */
    String getMessage() {
        return content;
    }
}