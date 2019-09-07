package com.glqdlt.pm6.entity.upload;

/**
 * Date 2019-08-17
 *
 * @author glqdlt
 */
public interface ImageFile {
    String getImageExtension();

    String getName();

    default String getImageType() {
        String ee = getImageExtension();
        if (ee.indexOf(".") == 0) {
            ee = ee.substring(1);
        }
        return ee.toUpperCase();
    }

    default void isImageFile(String name) {
        if (!name.contains(".")) {
            throw new FileNameIsNotContainExtension();
        }
    }

    default String extensionExtract(String image) {
        return image.substring(image.lastIndexOf("."));
    }

    class FileNameIsNotContainExtension extends RuntimeException {
        public FileNameIsNotContainExtension() {
            super("file name is must contain '.' quoter");
        }
    }

}
