package com.glqdlt.pm6.webcms.web.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Date 2019-08-10
 *
 * @author glqdlt
 */
@RequestMapping("/api")
@RestController
public class SomeRestController {
    @GetMapping("/")
    public String aa(){
        return "hi";
    }
}
