package com.glqdlt.pm6.webcms.web.error.view;

/**
 * Date 2019-11-16
 *
 * @author glqdlt
 */
public class ExistItemError extends ClientBadRequestViewError {
    public ExistItemError(Throwable t) {
        super(t);
    }

    @Override
    public String getPm6ErrorCode() {
        return "C001X";
    }
}
