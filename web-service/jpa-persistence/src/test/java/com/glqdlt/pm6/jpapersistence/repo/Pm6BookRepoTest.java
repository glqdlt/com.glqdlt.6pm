package com.glqdlt.pm6.jpapersistence.repo;

import com.glqdlt.pm6.jpapersistence.Pm6PersistenceInitTest;
import com.glqdlt.pm6.jpapersistence.author.entity.Pm6AuthorEntity;
import com.glqdlt.pm6.jpapersistence.book.entity.Pm6BookEntity;
import com.glqdlt.pm6.jpapersistence.book.repo.Pm6BookRepo;
import com.glqdlt.pm6.jpapersistence.tag.entity.Pm6TagEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Date 2019-11-14
 *
 * @author glqdlt
 */
@DataJpaTest
@RunWith(SpringRunner.class)
@Import(Pm6PersistenceInitTest.JpaTestEntityScanConfig.class)
public class Pm6BookRepoTest {

    @Autowired
    private Pm6BookRepo bookRepo;

    @Test
    public void repoIsNotNull() {
        Assert.assertNotNull(bookRepo);
    }

    @Autowired
    private EntityManager entityManager;

    @Before
    public void setUp() throws Exception {
        Pm6TagEntity pm6TagEntity = new Pm6TagEntity();
        pm6TagEntity.setRegDate(LocalDateTime.of(2019, 2, 2, 2, 2, 2));
        pm6TagEntity.setTagName("JAVA");

        Pm6AuthorEntity pm6AuthorEntity = new Pm6AuthorEntity();
        pm6AuthorEntity.setName("로버트 마틴");
        pm6AuthorEntity.setRegDate(LocalDateTime.of(2019, 1, 1, 1, 1));

        Pm6BookEntity bookEntity = new Pm6BookEntity();
        bookEntity.setTags(Collections.singletonList(pm6TagEntity));
        bookEntity.setAuthors(Collections.singletonList(pm6AuthorEntity));
        bookEntity.setDescription("테스트");
        bookEntity.setRegDate(LocalDateTime.of(2019, 3, 3, 3, 3, 3));
        bookEntity.setTitle("클린코더");

        bookRepo.save(bookEntity);
    }

    @Test
    public void findTitleSearch() {
        Optional<Pm6BookEntity> book = bookRepo.findByTitle("클린코더");
        Assert.assertTrue(book.isPresent());
        Pm6BookEntity b = book.get();
        expected(b.getTitle(), b.getAuthors().get(0).getName(), b.getDescription(), b.getTags().get(0).getTagName());
    }

    void expected(String title, String author, String desc, String tag) {
        Assert.assertEquals("클린코더", title);
        Assert.assertEquals("JAVA", tag);
        Assert.assertEquals("로버트 마틴", author);
        Assert.assertEquals("테스트", desc);
    }

    @Test
    public void findTitleLike() {
        List<Pm6BookEntity> e = bookRepo.findAllByTitleLike("클린%");
        Assert.assertEquals(1, e.size());
        Pm6BookEntity b = e.get(0);
        expected(b.getTitle(), b.getAuthors().get(0).getName(), b.getDescription(), b.getTags().get(0).getTagName());

    }

}
