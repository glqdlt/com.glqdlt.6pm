package com.glqdlt.pm6.webservice.app;

import com.glqdlt.pm6.api.model.bbs.BoardContents;
import com.glqdlt.pm6.api.model.write.Writeable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import static com.glqdlt.pm6.webservice.app.SearchBoardAble.MODEL_ATTRIBUTE_KEY;

/**
 * Date 2019-09-07
 *
 * @author glqdlt
 */
public interface DetailBoardAble<T extends Writeable> extends WrongParamHandler {
    String getDetailBoardView();

    T pillDetailContents(Integer id);

    @GetMapping("/{id}")
    default ModelAndView boardDetail(@PathVariable Integer id) {
        T e = pillDetailContents(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setStatus(HttpStatus.OK);
        modelAndView.setViewName(getDetailBoardView());
        modelAndView.getModel().put(MODEL_ATTRIBUTE_KEY, e);
        return modelAndView;
    }
}
