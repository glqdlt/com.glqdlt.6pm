package com.glqdlt.pm6.webservice.entity.write;

import java.time.LocalDateTime;

/**
 * Date 2019-08-04
 *
 * @author glqdlt
 */
public abstract class Upload {

    private Long id;
    private String name;
    private String path;
    private String hash;
    private LocalDateTime regDate;

    public LocalDateTime getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDateTime regDate) {
        this.regDate = regDate;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public abstract com.glqdlt.pm6.webservice.entity.upload.Upload.UploadType getType();

    public static class LinkUpload extends Upload{

        @Override
        public com.glqdlt.pm6.webservice.entity.upload.Upload.UploadType getType() {
            return com.glqdlt.pm6.webservice.entity.upload.Upload.UploadType.LINK;
        }
    }

    public static class StorageArchive extends Upload {
        private String extension;

        public String getExtension() {
            return extension;
        }

        public void setExtension(String extension) {
            this.extension = extension;
        }

        @Override
        public com.glqdlt.pm6.webservice.entity.upload.Upload.UploadType getType() {
            return com.glqdlt.pm6.webservice.entity.upload.Upload.UploadType.STORAGE_ARCHIVE;
        }
    }

    public static class EmbeddedThumbnail extends Upload {
        private String imageFormat;

        public String getData() {
            return getPath();
        }

        public String getImageFormat() {
            return imageFormat;
        }

        public void setImageFormat(String imageFormat) {
            this.imageFormat = imageFormat;
        }

        @Override
        public com.glqdlt.pm6.webservice.entity.upload.Upload.UploadType getType() {
            return com.glqdlt.pm6.webservice.entity.upload.Upload.UploadType.DATABASE_EMBEDDED;
        }
    }

}
