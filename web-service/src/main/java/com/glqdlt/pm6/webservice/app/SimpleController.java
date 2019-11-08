package com.glqdlt.pm6.webservice.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Date 2019-11-08
 *
 * @author glqdlt
 */
@RestController
public class SimpleController {

    private Logger logger = LoggerFactory.getLogger(SimpleController.class);

    @GetMapping("/echo")
    public void echo(String message){
        logger.info(message);
    }
}
