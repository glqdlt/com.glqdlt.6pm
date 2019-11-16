package com.glqdlt.pm6.webcms.web.controller.restful.book;

import com.glqdlt.pm6.persistence.book.entity.Pm6BookEntity;
import com.glqdlt.pm6.webcms.functions.CommaStringListMappers;
import com.glqdlt.pm6.webcms.web.error.book.NotUniqueBookPropsError;
import com.glqdlt.pm6.webcms.web.error.book.Pm6BookError;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

/**
 * Date 2019-11-10
 *
 * @author glqdlt
 */
@RestController
@RequestMapping("/api/v1")
public class BookRestController {

    private BookService bookService;

    private List<String> parsingComma(String str) {
        if (str == null || str.equals("")) {
            return new LinkedList<>();
        }
        return CommaStringListMappers.STRING_BYPASS.parsing(str);
    }

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping(value = "/book/new",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ResponseEntity postBookNew(
            @RequestParam String title,
            @RequestParam String authors,
            @RequestParam(required = false) String tags,
            @RequestParam(required = false) String description) {

        List<String> a = parsingComma(authors);
        List<String> t = parsingComma(tags);
        try {
            Pm6BookEntity newBook = bookService
                    .createNewBook(title, a, t, description);
            return ResponseEntity.status(HttpStatus.OK).body(newBook);
        } catch (NotUniqueBookPropsError e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }

    }

    @GetMapping(value = "/books")
    public ResponseEntity getBooks() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(bookService.findAllBooks());
    }
}
