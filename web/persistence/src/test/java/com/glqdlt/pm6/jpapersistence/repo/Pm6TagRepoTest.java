package com.glqdlt.pm6.jpapersistence.repo;

import com.glqdlt.pm6.jpapersistence.Pm6PersistenceInitTest;
import com.glqdlt.pm6.jpapersistence.tag.entity.Pm6TagEntity;
import com.glqdlt.pm6.jpapersistence.tag.repo.Pm6TagRepo;
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
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Jhun
 * 2019-11-15
 */
@DataJpaTest
@RunWith(SpringRunner.class)
@Import(Pm6PersistenceInitTest.JpaTestEntityScanConfig.class)
public class Pm6TagRepoTest {


    @Autowired
    private Pm6TagRepo pm6TagRepo;


    @Autowired
    private EntityManager entityManager;

    @Before
    public void setUp() throws Exception {

        List<Pm6TagEntity> z = IntStream.rangeClosed(1, 10).boxed()
                .map(x -> {
                    Pm6TagEntity pm6TagEntity = new Pm6TagEntity();
                    pm6TagEntity.setRegDate(LocalDateTime.of(2019, 1, 1, 1, 1));
                    pm6TagEntity.setTagName(x % 2 == 0 ? "java" + x : "javascript" + x);
                    return pm6TagEntity;
                }).collect(Collectors.toList());

        pm6TagRepo.saveAll(z);
    }

    /**
     * xxxIsLike 나 xxxLike 는 같음
     * xxxLike vs xxxContains 는 쿼리는 실제로 like 로 둘다 동일함
     * 차이점은 xxxLike 는 % 와일드카드를 붙여줘야하며, xxxContains 는 암묵적으로 jpa에서 붙여버림.
     * xxxContains,xxxStartWith , xxxEndWith 와 같은 like 절의 헬퍼 메소드들이 있는 데, 이름에서 유추하듯 % 를 어디에 붙이냐 차이임
     * xxxStartsWith 와 xxxStartingWith 의 차이점은 모르겄다.
     */
    @Test
    public void searchTags() {
        List<Pm6TagEntity> allTags = pm6TagRepo.findAll();
        Assert.assertEquals(10, allTags.size());
        List<Pm6TagEntity> java2Andjava4 = pm6TagRepo.findAllByTagNameIsIn("java2", "java4");
        Assert.assertEquals("java2", java2Andjava4.get(0).getTagName());
        Assert.assertEquals("java4", java2Andjava4.get(1).getTagName());
        List<Pm6TagEntity> javaStartWith = pm6TagRepo.findAllByTagNameStartsWith("java");
        Assert.assertEquals(10, javaStartWith.size());
        List<Pm6TagEntity> allJavaScriptTag = pm6TagRepo.findAllByTagNameStartsWith("javascript");
        Assert.assertEquals(5, allJavaScriptTag.size());
    }
}