package com.glqdlt.pm6.webcms.web.error;

import com.glqdlt.pm6.webcms.web.error.view.Pm6ResponseViewError;

/**
 * Date 2019-11-16
 *
 * @author glqdlt
 */
public abstract class Pm6ClientError extends Pm6ResponseViewError {

    public Pm6ClientError(String message) {
        super(message);
    }

    public Pm6ClientError(String message, Throwable cause) {
        super(message, cause);
    }

    public Pm6ClientError(Throwable cause) {
        super(cause);
    }
}
