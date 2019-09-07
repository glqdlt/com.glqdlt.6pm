package com.glqdlt.pm6.entity.upload;

/**
 * Date 2019-08-17
 *
 * @author glqdlt
 */
public class LinkThumbnailImage implements LinkThumbnail {
    private Long id;

    private String url;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String getLinkUrl() {
        return getUrl();
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
