package com.glqdlt.pm6.webcms.web.app;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Date 2019-11-09
 *
 * @author glqdlt
 */
@Controller
public class ErrorController {

    @ResponseStatus(code = HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @GetMapping(NOT_SUPPORTED_IE_PATH)
    public String notSupportedIe() {
        return "/error/not-support-browser";
    }

    public static final String NOT_SUPPORTED_IE_PATH = "/error/browser/notsupport";
}
