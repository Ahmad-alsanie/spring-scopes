package com.sanie.springscopes.websocket;

public class InteractionTracker {
    private int messageCount = 0;

    public void trackMessage(String message) {
        System.out.println("Tracking message: " + message);
        messageCount++;
    }

    public int getMessageCount() {
        return messageCount;
    }
}
