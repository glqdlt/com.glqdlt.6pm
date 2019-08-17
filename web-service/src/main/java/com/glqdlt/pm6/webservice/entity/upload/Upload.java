package com.glqdlt.pm6.webservice.entity.upload;

import java.util.stream.Stream;

/**
 * Date 2019-08-17
 *
 * @author glqdlt
 */
public interface Upload {
    String getFileName();

    String getHash();

    String getAbstractPath();

    enum UploadType {
        STORAGE_ARCHIVE(0),
        DATABASE_EMBEDDED(1),
        LINK(2);
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

}
