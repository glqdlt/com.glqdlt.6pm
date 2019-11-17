package com.glqdlt.pm6.webcms.web.app.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Date 2019-11-17
 *
 * @author glqdlt
 */
@Controller
public class UserController {
    @GetMapping("/user/login")
    public String getLogin() {
        return "user/login";
    }

    @PostMapping("/user/login")
    public String postLogin() {
        return null;
    }

    @GetMapping("/user/logout")
    public String getLogout(){
//        FIXME fill ... body
        return "redirect:/user/login";
    }

    @GetMapping("/user/join")
    public String getJoin(){
        return "user/join";
    }

    @GetMapping("/user/password/change")
    public String getPasswordChange(){
        return "user/password/passwordChangeForm";
    }
    @GetMapping("/user/password/help")
    public String getPasswordEmailHelp(){
        return "user/password/emailMagicLink";
    }
}
