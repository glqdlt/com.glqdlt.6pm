package com.glqdlt.pm6.webservice.app;

import com.glqdlt.pm6.api.model.bbs.BoardContents;
import com.glqdlt.pm6.api.model.paging.BoardPageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Date 2019-09-07
 *
 * @author glqdlt
 */
public interface SearchBoardAble<T extends BoardContents> extends WrongParamHandler {
    String MODEL_ATTRIBUTE_KEY = "contents";

    String getBoardView();

    BoardPageable<T> pillBoardSearchList(Integer[] type, String[] keyword, Integer page);

    @GetMapping
    default ModelAndView boardSearch(@RequestParam(required = false) Integer[] t,
                                     @RequestParam(required = false) String[] k,
                                     @RequestParam(required = false) Integer p) {
        Object contents = pillBoardSearchList(t, k, p);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setStatus(HttpStatus.OK);
        modelAndView.setViewName(getBoardView());
        modelAndView.getModel().put(MODEL_ATTRIBUTE_KEY, contents);
        return modelAndView;
    }

}
