package com.glqdlt.pm6.webcms.web.error;

/**
 * Date 2019-11-16
 *
 * @author glqdlt
 */
public abstract class Pm6Error extends RuntimeException implements Pm6ErrorCode {
    public Pm6Error(String message) {
        super(message);
    }

    public Pm6Error(String message, Throwable cause) {
        super(message, cause);
    }

    public Pm6Error(Throwable cause) {
        super(cause);
    }
}
