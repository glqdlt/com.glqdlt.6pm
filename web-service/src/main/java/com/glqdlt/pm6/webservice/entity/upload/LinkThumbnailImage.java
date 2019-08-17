package com.glqdlt.pm6.webservice.entity.upload;

/**
 * Date 2019-08-17
 *
 * @author glqdlt
 */
public class LinkThumbnailImage extends ThumbnailImage implements Link {
    private String url;
    public static final Integer LinkThumbnailImageType = 0;

    @Override
    public String getImageSource() {
        return getLinkUrl();
    }

    @Override
    public String getLinkUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public Integer getThumbnailType() {
        return LinkThumbnailImageType;
    }
}
