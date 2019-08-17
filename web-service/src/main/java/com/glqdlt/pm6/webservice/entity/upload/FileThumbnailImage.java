package com.glqdlt.pm6.webservice.entity.upload;

/**
 * Date 2019-08-17
 *
 * @author glqdlt
 */
public abstract class FileThumbnailImage  extends ThumbnailImage implements ImageFile {

    private String name;

    private String imageExtension;

    public FileThumbnailImage() {
    }

    public FileThumbnailImage(String name) {
        setName(name);
        setImageExtension(extensionExtract(getName()));
    }

    public String getImageExtension() {
        return imageExtension;
    }

    public String extensionExtract(String image) {
        return image.substring(image.lastIndexOf("."));
    }

    public void setImageExtension(String imageExtension) {
        this.imageExtension = imageExtension;
    }

    private void isImageFile(String name) {
        if (!name.contains(".")) {
            throw new FileNameIsNotContainExtension();
        }
    }

    public static class FileNameIsNotContainExtension extends RuntimeException {
        public FileNameIsNotContainExtension() {
            super("file name is must contain '.' quoter");
        }
    }

    @Override
    public String getImageType() {
        String ee = getImageExtension();
        if (ee.indexOf(".") == 0) {
            ee = ee.substring(1);
        }
        return ee.toUpperCase();
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        isImageFile(name);
        this.name = name;
    }
}
