package com.glqdlt.pm6.webcms.web.app.chat;

import java.util.List;

/**
 * Date 2019-11-24
 *
 * @author glqdlt
 */
public class BasicUserChatMessage extends UserChatMessage{
    public BasicUserChatMessage(String userName, String message, List<UserIcon> icons) {
        super(userName, message, icons);
    }

    @Override
    public Integer getMessageType() {
        return 1;
    }
}
