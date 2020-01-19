package com.glqdlt.pm6.api.model.book.archive;

public class RidiBookArchive extends Pm6BookArchiveBase {
    private String ridibooksBookUrl;

    @Override
    public String getBaseUrl() {
        return "https://ridibooks.com/";
    }

    @Override
    public String getDownloadUrl() {
        return ridibooksBookUrl;
    }

    public String getRidibooksBookUrl() {
        return ridibooksBookUrl;
    }

    public void setRidibooksBookUrl(String ridibooksBookUrl) {
        this.ridibooksBookUrl = ridibooksBookUrl;
    }

    @Override
    public Integer getArchiveType() {
        return ArchiveType.RIDI_BOOKS.ordinal();
    }
}
