package com.glqdlt.pm6.webservice.entity.write;

/**
 * Date 2019-08-04
 *
 * @author glqdlt
 */
public abstract class Upload {

    private Long id;
    private String name;
    private String path;

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

    public abstract UploadType getType();

    public static class File extends Upload {
        private String extension;

        public String getExtension() {
            return extension;
        }

        public void setExtension(String extension) {
            this.extension = extension;
        }

        @Override
        public UploadType getType() {
            return UploadType.FILE;
        }
    }

    public static class Image extends Upload {
        private String imageFormat;

        public String getImageFormat() {
            return imageFormat;
        }

        public void setImageFormat(String imageFormat) {
            this.imageFormat = imageFormat;
        }

        @Override
        public UploadType getType() {
            return UploadType.IMAGE;
        }
    }
}
