package com.glqdlt.pm6.api.model.book.archive;

import java.time.LocalDateTime;

public interface Pm6BookArchive {

    String getBaseUrl();

    String getDownloadUrl();

    String getName();

    Integer getArchiveType();

    LocalDateTime getRegDate();

}
