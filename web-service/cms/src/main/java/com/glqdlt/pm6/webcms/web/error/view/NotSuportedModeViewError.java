package com.glqdlt.pm6.webcms.web.error.view;

import org.springframework.http.HttpStatus;

import java.util.stream.Stream;

/**
 * Date 2019-11-19
 *
 * @author glqdlt
 */
public class NotSuportedModeViewError extends ErrorPageResponseViewError {
    public NotSuportedModeViewError(String... arg) {
        super(String.format("not supported mode.. '%s'",
                Stream.of(arg).reduce((acc, x) -> acc + "," + x).orElse("")));
    }

    @Override
    public Integer getHttpStatusCode() {
        return HttpStatus.METHOD_NOT_ALLOWED.value();
    }

    @Override
    public String getPm6ErrorCode() {
        return "C002X";
    }
}
