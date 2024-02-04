package com.sanie.springscopes.websocket;

import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MyWebSocketHandler extends TextWebSocketHandler {
    // Store trackers for all active sessions
    private final Map<String, InteractionTracker> sessionTrackers = new ConcurrentHashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // Initialize and store an InteractionTracker for the session
        InteractionTracker tracker = new InteractionTracker();
        sessionTrackers.put(session.getId(), tracker);
        System.out.println("Session opened, tracker initialized for session: " + session.getId());
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // Retrieve the tracker for this session and track the message
        InteractionTracker tracker = sessionTrackers.get(session.getId());
        if (tracker != null) {
            tracker.trackMessage(message.getPayload());
            session.sendMessage(new TextMessage("Message received: " + message.getPayload() + ". Message count: " + tracker.getMessageCount()));
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        // Clean up the tracker when session is closed
        sessionTrackers.remove(session.getId());
        System.out.println("Session closed, tracker removed for session: " + session.getId());
    }
}
