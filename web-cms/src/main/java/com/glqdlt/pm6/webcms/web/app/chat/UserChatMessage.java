package com.glqdlt.pm6.webcms.web.app.chat;

import java.util.LinkedList;
import java.util.List;

/**
 * Date 2019-11-24
 *
 * @author glqdlt
 */
public abstract class UserChatMessage {
    private String userName;
    private String message;

    public UserChatMessage(String userName,
                           String message,
                           List<UserIcon> icons) {
        if (icons == null) {
            this.icons = new LinkedList<>();
        } else {
            this.icons = icons;
        }
        this.userName = userName;
        this.message = message;
    }

    public abstract Integer getMessageType();

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private List<UserIcon> icons;

    public String getUserName() {
        return userName;
    }

    public List<UserIcon> getIcons() {
        return icons;
    }

    public void addIcon(UserIcon userIcon) {
        getIcons().add(userIcon);
    }

}
