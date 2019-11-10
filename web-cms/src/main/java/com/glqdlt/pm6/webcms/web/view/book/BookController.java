package com.glqdlt.pm6.webcms.web.view.book;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Date 2019-11-10
 *
 * @author glqdlt
 */
@Controller
public class BookController {
    @GetMapping("/book/new")
    public String getBook() {
        return "book-input-form";
    }
}
