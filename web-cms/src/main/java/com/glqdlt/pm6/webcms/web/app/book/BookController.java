package com.glqdlt.pm6.webcms.web.app.book;

import com.glqdlt.pm6.persistence.book.entity.Pm6BookEntity;
import com.glqdlt.pm6.webcms.web.app.book.model.BookEditModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

/**
 * Date 2019-11-10
 *
 * @author glqdlt
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/v1/view/book/new")
    public String getNewBook() {
        return "bookEditForm";
    }

    @GetMapping("/v1/view/book/{no}/edit")
    public String getNewBook(@PathVariable Long no, Model model) {
        Optional<Pm6BookEntity> b = bookService.findByBookId(no);
        if (b.isPresent()) {
            model.addAttribute("book", new BookEditModel(b.get()));
            return "bookUpdateForm";
        } else {
            throw new IllegalArgumentException("Wrong Request");
        }
    }

    @GetMapping("/v1/view/book")
    public String getBooks() {
        return "bookTable";
    }
}
