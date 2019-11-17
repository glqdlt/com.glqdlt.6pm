package com.glqdlt.pm6.webcms.web.app.book;

import com.glqdlt.pm6.webcms.functions.CommaStringListMappers;
import com.glqdlt.pm6.webcms.web.error.book.NotUniqueBookPropsError;
import org.springframework.http.HttpHeaders;
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
@RequestMapping("/v1/api")
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
            bookService.createNewBook(title, a, t, description);
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("location", "/v1/view/book");
            return new ResponseEntity(httpHeaders, HttpStatus.FOUND);
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
