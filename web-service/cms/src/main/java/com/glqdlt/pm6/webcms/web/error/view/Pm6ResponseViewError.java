package com.glqdlt.pm6.webcms.web.error.view;

import com.glqdlt.pm6.webcms.web.error.AbstractPm6ResponseEntityError;

/**
 * Date 2019-11-16
 *
 * @author glqdlt
 */
public abstract class Pm6ResponseViewError extends AbstractPm6ResponseEntityError implements ErrorViewingable {

    public Pm6ResponseViewError(String message) {
        super(message);
    }

    public Pm6ResponseViewError(String message, Throwable cause) {
        super(message, cause);
    }

    public Pm6ResponseViewError(Throwable cause) {
        super(cause);
    }
}
