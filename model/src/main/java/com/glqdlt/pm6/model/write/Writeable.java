package com.glqdlt.pm6.model.write;

import java.time.LocalDateTime;

/**
 * Date 2019-08-04
 *
 * @author glqdlt
 */
public interface Writeable {
    Long getWriteId();

    String getWriteSubject();

    String getWriteContents();

    LocalDateTime getWriteRegDate();

    String getWriter();
}
