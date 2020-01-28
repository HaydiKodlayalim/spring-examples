package com.haydikodlayalim.ws.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin
public class ChatController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat")
    //@SendTo("/topic")
    //@SendToUser()
    public void chatEndpoint(@Payload WsMessage wsMessage) {
        System.out.println(wsMessage);
        messagingTemplate.convertAndSend("/topic", wsMessage);
    }
}
