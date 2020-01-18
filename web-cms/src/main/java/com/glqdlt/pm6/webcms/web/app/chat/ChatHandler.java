package com.glqdlt.pm6.webcms.web.app.chat;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * Date 2019-11-24
 *
 * @author glqdlt
 */
@Controller
public class ChatHandler {
    @MessageMapping("/chat")
    @SendTo("/ws/v1/sub/chat")
    public BasicUserChatMessage message(String message) {
//        FIXME need .. xss escape
        return new BasicUserChatMessage("guest", message, null);
    }

}
