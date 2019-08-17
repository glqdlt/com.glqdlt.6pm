package com.glqdlt.pm6.webservice.entity.upload;

/**
 * Date 2019-08-17
 *
 * @author glqdlt
 */
public interface ThumbnailImage extends ImageSource, Thumbnail {
    Long getId();
    void setId(Long id);
}
