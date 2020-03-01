package com.glqdlt.pm6.webcms.web.error.book;

import com.glqdlt.pm6.webcms.web.error.Pm6Error;

/**
 * Date 2019-11-16
 *
 * @author glqdlt
 */
public abstract class Pm6BookError extends Pm6Error {
    public Pm6BookError(String message) {
        super(message);
    }

    public Pm6BookError(String message, Throwable cause) {
        super(message, cause);
    }

    public Pm6BookError(Throwable cause) {
        super(cause);
    }
}
