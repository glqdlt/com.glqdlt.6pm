package com.glqdlt.pm6.api.model.book.archive;

import java.time.LocalDateTime;

public abstract class Pm6BookArchiveBase implements Pm6BookArchive {
    private String name;
    private LocalDateTime regDate;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public LocalDateTime getRegDate() {
        return regDate;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setRegDate(LocalDateTime regDate) {
        this.regDate = regDate;
    }
}
