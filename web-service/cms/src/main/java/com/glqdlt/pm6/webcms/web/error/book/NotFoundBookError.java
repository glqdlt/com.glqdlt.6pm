package com.glqdlt.pm6.webcms.web.error.book;

/**
 * Date 2019-11-17
 *
 * @author glqdlt
 */
public class NotFoundBookError extends Pm6BookError {
    public NotFoundBookError(String title) {
        super(String.format("title '%s' Not Found Book", title));
    }
    public NotFoundBookError(Long no) {
        super(String.format("no '%s' Not Found Book", no));
    }

    @Override
    public String getPm6ErrorCode() {
        return "B002";
    }
}
