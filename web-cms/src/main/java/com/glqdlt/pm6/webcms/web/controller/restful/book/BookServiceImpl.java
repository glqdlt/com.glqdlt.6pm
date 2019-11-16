package com.glqdlt.pm6.webcms.web.controller.restful.book;

import com.glqdlt.pm6.persistence.book.entity.Pm6BookEntity;
import com.glqdlt.pm6.persistence.book.repo.Pm6BookRepo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Date 2019-11-16
 *
 * @author glqdlt
 */
@Service
public class BookServiceImpl implements BookService {
    private Pm6BookRepo pm6BookRepo;

    public BookServiceImpl(Pm6BookRepo pm6BookRepo) {
        this.pm6BookRepo = pm6BookRepo;
    }

    public List<Pm6BookEntity> findAllBooks() {
        return pm6BookRepo.findAll();
    }
}
