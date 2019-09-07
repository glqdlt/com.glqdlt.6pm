package com.glqdlt.pm6.webservice.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Date 2019-09-07
 *
 * @author glqdlt
 */
public interface WrongParamHandler {

    Logger getLogger();

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    default ModelAndView wrongMethodParam(MethodArgumentTypeMismatchException e,
                                          HttpServletRequest httpServletRequest) {
        getLogger().info(httpServletRequest.getRemoteAddr());
        getLogger().error(e.getMessage(), e);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("400");
        modelAndView.setStatus(HttpStatus.BAD_REQUEST);
        return modelAndView;
    }
}
