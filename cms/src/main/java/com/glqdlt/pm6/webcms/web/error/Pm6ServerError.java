package com.glqdlt.pm6.webcms.web.error;

import com.glqdlt.pm6.webcms.web.error.view.Pm6ResponseViewError;

/**
 * Date 2019-11-16
 *
 * @author glqdlt
 */
public abstract class Pm6ServerError extends Pm6ResponseViewError {
    public Pm6ServerError(String message) {
        super(message);
    }

    public Pm6ServerError(String message, Throwable cause) {
        super(message, cause);
    }

    public Pm6ServerError(Throwable cause) {
        super(cause);
    }

    @Override
    public Integer getHttpStatusCode() {
        return 500;
    }
}
