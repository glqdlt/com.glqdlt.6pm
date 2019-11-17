package com.glqdlt.pm6.webcms.web.app.book;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Date 2019-11-10
 *
 * @author glqdlt
 */
@Controller
public class BookController {
    @GetMapping("/v1/view/book/new")
    public String getNewBook() {
        return "book-edit-form";
    }

    @GetMapping("/v1/view/book")
    public String getBooks(){return "book-table";}
}
