package com.glqdlt.pm6.webservice.entity.upload;

/**
 * Date 2019-08-17
 *
 * @author glqdlt
 */
public abstract class ThumbnailImage implements ThumbnailImageSource{
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public abstract Integer getThumbnailType();
}
