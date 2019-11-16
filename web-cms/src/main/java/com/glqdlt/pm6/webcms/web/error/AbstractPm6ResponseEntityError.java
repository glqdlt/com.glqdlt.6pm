package com.glqdlt.pm6.webcms.web.error;

/**
 * Date 2019-11-16
 *
 * @author glqdlt
 */
public abstract class AbstractPm6ResponseEntityError extends Pm6Error {
    public abstract Integer getHttpStatusCode();

    public AbstractPm6ResponseEntityError(String message) {
        super(message);
    }

    public AbstractPm6ResponseEntityError(String message, Throwable cause) {
        super(message, cause);
    }

    public AbstractPm6ResponseEntityError(Throwable cause) {
        super(cause);
    }
}
