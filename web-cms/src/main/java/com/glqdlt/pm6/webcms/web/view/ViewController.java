package com.glqdlt.pm6.webcms.web.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Date 2019-08-10
 *
 * @author glqdlt
 */
@Controller
public class ViewController {

    public static final String NOT_SUPPORTED_IE_PATH = "/error/notSupported";
    @GetMapping("/")
    public String root() {
        return "root";
    }

    @GetMapping(NOT_SUPPORTED_IE_PATH)
    public String notSupportedIe() {
        return "/error/not-supported-ie";
    }
}
