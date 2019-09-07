package com.glqdlt.pm6.webservice.app.book;

import com.glqdlt.pm6.webservice.app.SearchArticle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Date 2019-09-07
 *
 * @author glqdlt
 */
@Controller
@RequestMapping("/book")
public class BookController implements SearchArticle {

    /**
     * 참고) JDK8 기준으로 static 도 heap area 로 넘어갔기 때문에, static 이 의미가 없어서 아래처럼 했음. 참고
     */
    final Logger logger = LoggerFactory.getLogger(BookController.class);
    @Override
    public String getArticleViewName() {
        return "book";
    }

    @Override
    public String getArticleDetailViewName() {
        return "book-detail";
    }

    @Override
    public Object pillArticleSearchContents(Integer[] type, String[] keyword) {
        return null;
    }

    @Override
    public Object pillArticleDetailContents(Integer id) {
        return null;
    }
}
