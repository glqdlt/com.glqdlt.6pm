package com.glqdlt.pm6.webservice.entity.upload;

/**
 * Date 2019-08-17
 *
 * @author glqdlt
 */
public class EmbeddedThumbnailImage extends FileThumbnailImage implements DataBaseEmbeddedFile {
    public static final Integer EmbeddedThumbnailImageType = 1;
//    LongText
//    @Lob
    private String data;

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String getImageSource() {
        return String.format("data:image/%s;base64, %s", getImageType().toLowerCase(), getData());
    }

    @Override
    public String getData() {
        return data;
    }

    @Override
    public Integer getThumbnailType() {
        return EmbeddedThumbnailImageType;
    }
}
