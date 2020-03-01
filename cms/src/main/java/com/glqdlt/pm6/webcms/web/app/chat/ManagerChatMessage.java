package com.glqdlt.pm6.webcms.web.app.chat;

import java.util.List;

/**
 * Date 2019-11-24
 *
 * @author glqdlt
 */
public class ManagerChatMessage extends UserChatMessage {

    public ManagerChatMessage(String userName, String message, List<UserIcon> icons) {
        super(userName, message, icons);
        addIcon(new UserIcon() {
            @Override
            public String getUrl() {
                return "{someicon}";
            }

            @Override
            public String getLabel() {
                return "managerIcon";
            }
        });
    }

    @Override
    public Integer getMessageType() {
        return 0;
    }
}
