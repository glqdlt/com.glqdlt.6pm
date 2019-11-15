package com.glqdlt.pm6.webcms.web.controller.restful.book;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Date 2019-11-10
 *
 * @author glqdlt
 */
@RestController
@RequestMapping("/api/v1")
public class BookRestController {

    @PostMapping(value = "/book/new", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity postBookNew(
            @RequestParam String title,
            @RequestParam String author,
            @RequestParam(required = false) String tag,
            @RequestParam(required = false) String description) {

        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
