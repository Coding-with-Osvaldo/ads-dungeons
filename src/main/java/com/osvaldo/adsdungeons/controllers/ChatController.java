package com.osvaldo.adsdungeons.controllers;

import com.osvaldo.adsdungeons.domain.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage message){
        return message;
    }
    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage message, SimpMessageHeaderAccessor simpMessageHeaderAccessor){
        simpMessageHeaderAccessor.getSessionAttributes().put("username", message.getSender());
        return message;
    }
}