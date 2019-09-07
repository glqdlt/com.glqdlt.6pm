package com.glqdlt.pm6.webservice.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Date 2019-09-07
 *
 * @author glqdlt
 */
public interface SearchArticle {
    String MODEL_ATTRIBUTE_KEY = "contents";
    Logger logger = LoggerFactory.getLogger(SearchArticle.class);

    String getArticleViewName();

    Object pillArticleSearchContents(Integer[] type, String[] keyword);

    String getArticleDetailViewName();

    Object pillArticleDetailContents(Integer id);

    @GetMapping("/{id}")
    default ModelAndView bookDetail(@PathVariable Integer id) {
        Object e = pillArticleDetailContents(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setStatus(HttpStatus.OK);
        modelAndView.setViewName(getArticleDetailViewName());
        modelAndView.getModel().put(MODEL_ATTRIBUTE_KEY, e);
        return modelAndView;
    }

    @GetMapping
    default ModelAndView articleWithSearch(@RequestParam(required = false) Integer[] type,
                                           @RequestParam(required = false) String[] keyword) {
        Object contents = pillArticleSearchContents(type, keyword);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setStatus(HttpStatus.OK);
        modelAndView.setViewName(getArticleViewName());
        modelAndView.getModel().put(MODEL_ATTRIBUTE_KEY, contents);
        return modelAndView;
    }


    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    default ModelAndView wrongMethodParam(MethodArgumentTypeMismatchException e,
                                          HttpServletRequest httpServletRequest) {
        logger.info(httpServletRequest.getRemoteAddr());
        logger.error(e.getMessage(), e);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("400");
        modelAndView.setStatus(HttpStatus.BAD_REQUEST);
        return modelAndView;
    }
}
