package com.glqdlt.pm6.webservice.entity.write;

import java.util.stream.Stream;

/**
 * Date 2019-08-04
 *
 * @author glqdlt
 */
public enum UploadType {
    FILE(0),
    IMAGE(1);
    private Integer code;

    UploadType(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public static UploadType valueOf(Integer code) {
        return Stream.of(UploadType.values()).filter(x -> x.getCode().equals(code))
                .findAny().orElseThrow(() -> new IllegalArgumentException(String.format("Not matched code, %s", code)));
    }
}
