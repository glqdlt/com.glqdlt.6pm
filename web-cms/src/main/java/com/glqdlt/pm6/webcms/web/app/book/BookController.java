package com.glqdlt.pm6.webcms.web.app.book;

import com.glqdlt.pm6.persistence.author.entity.Pm6AuthorEntity;
import com.glqdlt.pm6.persistence.book.entity.Pm6BookEntity;
import com.glqdlt.pm6.persistence.tag.entity.Pm6TagEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Date 2019-11-10
 *
 * @author glqdlt
 */
@Controller
public class BookController {

    private String joinArrayToCommaString(Stream<String> target) {
        return target.reduce((acc, x) -> acc + "," + x).orElse("");
    }

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
            Pm6BookEntity book = b.get();
            model.addAttribute("location", String.format("/v1/api/book/%s/edit", book.getNo()));
            model.addAttribute("no", book.getNo());
            model.addAttribute("title", book.getTitle());
            model.addAttribute("authors", joinArrayToCommaString(book.getAuthors().stream().map(Pm6AuthorEntity::getName)));
            model.addAttribute("tags", joinArrayToCommaString(book.getTags().stream().map(Pm6TagEntity::getName)));
            model.addAttribute("description", book.getDescription());
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
