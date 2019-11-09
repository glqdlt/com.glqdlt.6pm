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

    @GetMapping("/")
    public String root() {
        return "root";
    }
    @GetMapping("/book/new")
    public String getBook(){
        return "book-input-form";
    }
}
