package com.glqdlt.pm6.webcms.web.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Date 2019-08-10
 *
 * @author glqdlt
 */
@RequestMapping("/v0/api")
@RestController
public class SomeRestController {
    /**
     * gateway 에서 헬스 체크할 때 찌르는 api
     */
    @GetMapping("/health")
    public void getHeartBeat() {

    }
}
