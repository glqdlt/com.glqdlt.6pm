package com.glqdlt.pm6.webcms.web.app.book;

import com.glqdlt.pm6.persistence.book.entity.Pm6BookEntity;
import com.glqdlt.pm6.webcms.web.app.book.model.BookCreateForm;
import com.glqdlt.pm6.webcms.web.app.book.model.BookUpdateForm;

import java.util.List;
import java.util.Optional;

/**
 * Date 2019-11-16
 *
 * @author glqdlt
 */
public interface BookService {
    List<Pm6BookEntity> findAllBooks();

    Pm6BookEntity createNewBook(BookCreateForm form);

    void deleteBook(Long bookNo);

    Optional<Pm6BookEntity> findByBookId(Long id);

    Pm6BookEntity updateBook(BookUpdateForm form);
}
