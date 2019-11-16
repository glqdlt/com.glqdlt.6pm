package com.glqdlt.pm6.webcms.web.error.view;

import org.springframework.http.HttpStatus;

/**
 * Date 2019-11-16
 *
 * @author glqdlt
 */
public abstract class ClientBadRequestViewError extends ErrorPageResponseViewError {
    public ClientBadRequestViewError(Throwable t) {
        super(t);
    }

    @Override
    public Integer getHttpStatusCode() {
        return HttpStatus.BAD_REQUEST.value();
    }

}
