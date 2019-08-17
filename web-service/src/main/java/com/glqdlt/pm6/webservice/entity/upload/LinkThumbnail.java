package com.glqdlt.pm6.webservice.entity.upload;

/**
 * Date 2019-08-17
 *
 * @author glqdlt
 */
public interface LinkThumbnail extends Link, ThumbnailImage {
    Integer LinkThumbnailImageType = 0;

    default String getImageSource() {
        return getLinkUrl();
    }

    default Integer getImageSourceType() {
        return LinkThumbnailImageType;
    }
}
