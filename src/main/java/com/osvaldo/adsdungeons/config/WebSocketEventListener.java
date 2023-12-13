package com.osvaldo.adsdungeons.config;

import com.osvaldo.adsdungeons.domain.ChatMessage;
import com.osvaldo.adsdungeons.domain.MessageType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
@RequiredArgsConstructor
@Slf4j
public class WebSocketEventListener {

    private final SimpMessageSendingOperations messageSendingOperations;

    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent sde){
        StompHeaderAccessor stompHeaderAccessor = StompHeaderAccessor.wrap(sde.getMessage());
        String userName = (String) stompHeaderAccessor.getSessionAttributes().get("username");

        if(userName != null){
            log.info("User disconnected: {}", userName);
            var chatMessage = ChatMessage.builder()
                    .type(MessageType.LEAVE)
                    .sender(userName)
                    .build();
            messageSendingOperations.convertAndSend("/topic/public", chatMessage);
        }
    }
}
