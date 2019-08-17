package com.glqdlt.pm6.webservice.entity.upload;

/**
 * Date 2019-08-17
 *
 * @author glqdlt
 */
public interface ThumbnailImageType {
    Integer getThumbnailType();

    interface BookThumnailImage extends ThumbnailImageType {
        @Override
        default Integer getThumbnailType() {
            return 1;
        }
    }

    interface AuthorThumbnailImage extends ThumbnailImageType {
        @Override
        default Integer getThumbnailType() {
            return 2;
        }
    }

}
