package com.glqdlt.pm6.webservice.app.book;

import com.glqdlt.pm6.model.article.BookArticle;
import com.glqdlt.pm6.model.bbs.BoardContents;
import com.glqdlt.pm6.model.bbs.BookBoardContents;
import com.glqdlt.pm6.model.book.Bookable;
import com.glqdlt.pm6.model.paging.BoardPageable;
import com.glqdlt.pm6.webservice.app.DetailBoardAble;
import com.glqdlt.pm6.webservice.app.SearchBoardAble;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Date 2019-09-07
 *
 * @author glqdlt
 */
@Controller
@RequestMapping("/book")
public class BookBoardController implements SearchBoardAble<BookBoardContents>, DetailBoardAble<BookArticle> {

    /**
     * 참고) JDK8 기준으로 static 도 heap area 로 넘어갔기 때문에, static 이 의미가 없어서 아래처럼 했음. 참고
     */
    private final Logger logger = LoggerFactory.getLogger(BookBoardController.class);

    @Override
    public String getBoardView() {
        return "book";
    }

    @Override
    public BoardPageable<BookBoardContents> pillBoardSearchList(Integer[] type, String[] keyword, Integer page) {
        return null;
    }

    @Override
    public String getDetailBoardView() {
        return "book-detail";
    }

    @Override
    public BookArticle pillDetailContents(Integer id) {
        return null;
    }

    @Override
    public Logger getLogger() {
        return logger;
    }
}
