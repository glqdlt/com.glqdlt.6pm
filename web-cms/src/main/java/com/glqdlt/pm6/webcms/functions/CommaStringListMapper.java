package com.glqdlt.pm6.webcms.functions;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Date 2019-11-16
 *
 * @author glqdlt
 */
@FunctionalInterface
public interface CommaStringListMapper<R> {

    R objectConvert(String str);

    default List<R> parsing(String origin) {
        return Stream.of(origin.split(",")).map(this::objectConvert)
                .collect(Collectors.toList());
    }
}
