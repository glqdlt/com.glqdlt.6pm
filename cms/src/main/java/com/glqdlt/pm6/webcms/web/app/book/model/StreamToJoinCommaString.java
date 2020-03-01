package com.glqdlt.pm6.webcms.web.app.book.model;

import java.util.stream.Stream;

/**
 * Date 2019-11-19
 *
 * @author glqdlt
 */
public interface StreamToJoinCommaString {
    default String joinArrayToCommaString(Stream<String> target) {
        return target.reduce((acc, x) -> acc + "," + x).orElse("");
    }
}
