package com.glqdlt.pm6.webcms.web.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Date 2019-08-10
 *
 * @author glqdlt
 */
@Controller
public class RootController {

    @GetMapping("/")
    public String root() {
        return "redirect:/v1/view/dashboard";
    }

    @GetMapping("/v1/view/dashboard")
    public String getDashboad(){
        return "dashboard";
    }
}
