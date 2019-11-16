package com.glqdlt.pm6.webcms.web.controller.restful.book;

import com.glqdlt.pm6.persistence.book.entity.Pm6BookEntity;

import java.util.List;

/**
 * Date 2019-11-16
 *
 * @author glqdlt
 */
public interface BookService {
    List<Pm6BookEntity> findAllBooks();
}
