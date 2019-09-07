package com.glqdlt.pm6.entity.upload;

/**
 * Date 2019-08-17
 *
 * @author glqdlt
 */
public abstract class EmbeddedThumbnailImage implements DataBaseEmbeddedFile, ImageFile, StreamThumbnail {
    public static final Integer EmbeddedThumbnailImageType = 1;
    private String imageExtension;
    private String embeddedData;
    private String name;
    private Long id;

    public void setImageExtension(String imageExtension) {
        this.imageExtension = imageExtension;
    }

    public void setName(String name) {
        isImageFile(name);
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmbeddedData(String embeddedData) {
        this.embeddedData = embeddedData;
    }

    @Override
    public String getImageSource() {
        return String.format("data:image/%s;base64, %s", getImageType().toLowerCase(), getEmbeddedData());
    }

    @Override
    public Integer getImageSourceType() {
        return EmbeddedThumbnailImageType;
    }

    @Override
    public String getEmbeddedData() {
        return embeddedData;
    }

    @Override
    public String getImageExtension() {
        return imageExtension;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Long getId() {
        return id;
    }

}
