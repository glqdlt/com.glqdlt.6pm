package com.glqdlt.pm6.webcms.web.app.book;

import com.glqdlt.pm6.webcms.web.app.book.model.BookCreateForm;
import com.glqdlt.pm6.webcms.web.app.book.model.BookUpdateForm;
import com.glqdlt.pm6.webcms.web.error.book.NotFoundBookError;
import com.glqdlt.pm6.webcms.web.error.book.NotUniqueBookPropsError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Date 2019-11-10
 *
 * @author glqdlt
 */
@RestController
@RequestMapping("/v1/api")
public class BookRestController {

    private BookService bookService;


    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping(value = "/book/{id}/delete")
    public ResponseEntity postBookDelete(@PathVariable(value = "id") Long bookNo) {

        try {
            bookService.deleteBook(bookNo);
            return ResponseEntity.status(200).build();
        } catch (NotFoundBookError notFoundBookError) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(notFoundBookError.getMessage());
        }


    }

    @PostMapping(value = "/book/{no}/edit",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ResponseEntity postUpdateBook(
            @PathVariable Long no,
            @RequestParam String title,
            @RequestParam String authors,
            @RequestParam(required = false) String tags,
            @RequestParam(required = false) String description,
            @RequestParam(required = false, name = "thumbnailUrl") String thumbnail) {
        try {
            bookService.updateBook(new BookUpdateForm(title, authors, tags, description, thumbnail, no));
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("location", "/v1/view/book");
            return new ResponseEntity(httpHeaders, HttpStatus.FOUND);
        } catch (
                NotUniqueBookPropsError e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }


    @PostMapping(value = "/book/new",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ResponseEntity postBookNew(
            @RequestParam String title,
            @RequestParam String authors,
            @RequestParam(required = false) String tags,
            @RequestParam(required = false) String description,
            @RequestParam(required = false, name = "thumbnailUrl") String thumbnail
    ) {
        try {
            bookService.createNewBook(new BookCreateForm(title, authors, tags, description, thumbnail));
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("location", "/v1/view/book");
            return new ResponseEntity(httpHeaders, HttpStatus.FOUND);
        } catch (
                NotUniqueBookPropsError e) {
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
