package com.glqdlt.pm6.webcms.web.error.book;

/**
 * Date 2019-11-16
 *
 * @author glqdlt
 */
public class NotUniqueBookPropsError extends Pm6BookError {

    public NotUniqueBookPropsError(String message) {
        super(message);
    }


    @Override
    public String getPm6ErrorCode() {
        return "B001";
    }
}
