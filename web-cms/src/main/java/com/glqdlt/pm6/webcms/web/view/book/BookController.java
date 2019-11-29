package com.glqdlt.pm6.webcms.web.view.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Locale;

/**
 * Date 2019-11-10
 *
 * @author glqdlt
 */
@Controller
public class BookController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/book/new")
    public String getBook(Locale locale
    ) {
        String z = messageSource.getMessage("hello", null, locale);
        System.out.println(z);
        return "book-input-form";
    }
}
