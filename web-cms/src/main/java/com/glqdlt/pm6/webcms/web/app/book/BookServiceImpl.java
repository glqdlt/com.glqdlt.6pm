package com.glqdlt.pm6.webcms.web.app.book;

import com.glqdlt.pm6.persistence.book.entity.Pm6BookEntity;
import com.glqdlt.pm6.persistence.book.repo.Pm6BookRepo;
import com.glqdlt.pm6.webcms.web.app.author.AuthorService;
import com.glqdlt.pm6.webcms.web.app.tag.TagService;
import com.glqdlt.pm6.webcms.web.error.book.NotFoundBookError;
import com.glqdlt.pm6.webcms.web.error.book.NotUniqueBookPropsError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Date 2019-11-16
 *
 * @author glqdlt
 */
@Slf4j
@Service
public class BookServiceImpl implements BookService {

    private Pm6BookRepo pm6BookRepo;

    private AuthorService authorService;

    private TagService tagService;

    public BookServiceImpl(Pm6BookRepo pm6BookRepo, AuthorService authorService, TagService tagService) {
        this.pm6BookRepo = pm6BookRepo;
        this.authorService = authorService;
        this.tagService = tagService;
    }

    public List<Pm6BookEntity> findAllBooks() {
        return pm6BookRepo.findAllByOrderByNoDesc();
    }

    public Optional<Pm6BookEntity> findBookByTitle(String title) {
        return pm6BookRepo.findByTitle(title);
    }

    @Transactional
    @Override
    public Pm6BookEntity createNewBook(String title, List<String> authors, List<String> tags, String description) {
        Optional<Pm6BookEntity> existBook = findBookByTitle(title);
        if (existBook.isPresent()) {
            throw new NotUniqueBookPropsError(String.format("타이틀 '%s'은 이미 존재합니다.", title));
        } else {
            Pm6BookEntity pm6BookEntity = new Pm6BookEntity();
            bookSetup(title, authors, tags, description, pm6BookEntity);

            return pm6BookRepo.save(pm6BookEntity);
        }
    }

    private void bookSetup(String title, List<String> authors, List<String> tags, String description, Pm6BookEntity pm6BookEntity) {
        if (authors == null || authors.size() == 0) {
            throw new IllegalArgumentException("Author is empty");
        }
        if (tags != null) {
            pm6BookEntity.setTags(tagService.onDuplicateAuthorFindOrPersist(tags));
        }
        pm6BookEntity.setAuthors(authorService.onDuplicateAuthorFindOrPersist(authors));
        pm6BookEntity.setTitle(title);
        pm6BookEntity.setRegDate(LocalDateTime.now());
        pm6BookEntity.setDescription(description);
    }

    public Pm6BookEntity findByBook(Long no) {
        return pm6BookRepo.findById(no).orElseThrow(() -> new NotFoundBookError(no));
    }

    @Override
    public void deleteBook(Long bookNo) {
        Pm6BookEntity b = findByBook(bookNo);
        pm6BookRepo.delete(b);
    }

    @Override
    public Optional<Pm6BookEntity> findByBookId(Long id) {
        return pm6BookRepo.findById(id);
    }

    @Transactional
    @Override
    public Pm6BookEntity updateBook(Long no, String title, List<String> authors, List<String> tags, String description) {
        Pm6BookEntity book = findByBook(no);
        bookSetup(title, authors, tags, description, book);
        return pm6BookRepo.save(book);
    }
}
