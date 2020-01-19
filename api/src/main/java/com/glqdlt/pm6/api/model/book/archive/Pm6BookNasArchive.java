package com.glqdlt.pm6.api.model.book.archive;

public class Pm6BookNasArchive extends Pm6BookArchiveBase {
    private Integer uploadedId;

    @Override
    public String getBaseUrl() {

//        TODO SpringEnvironmentHolder.getProperty() 랑 연결
        return null;
    }

    @Override
    public String getDownloadUrl() {
        return getBaseUrl() + "/" + uploadedId;
    }

    public Integer getUploadedId() {
        return uploadedId;
    }

    public void setUploadedId(Integer uploadedId) {
        this.uploadedId = uploadedId;
    }

    @Override
    public Integer getArchiveType() {
        return ArchiveType.NAS.ordinal();
    }
}
