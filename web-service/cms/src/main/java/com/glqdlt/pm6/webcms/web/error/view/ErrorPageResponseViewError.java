package com.glqdlt.pm6.webcms.web.error.view;

/**
 * Date 2019-11-16
 *
 * @author glqdlt
 */
public abstract class ErrorPageResponseViewError extends Pm6ResponseViewError {

    @Override
    public String getViewName() {
        return "error/code-message-error";
    }

    public ErrorPageResponseViewError(String message) {
        super(message);
    }

    public ErrorPageResponseViewError(String message, Throwable cause) {
        super(message, cause);
    }

    public ErrorPageResponseViewError(Throwable cause) {
        super(cause);
    }
}
