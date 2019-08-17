package com.glqdlt.pm6.webservice.entity.upload;

import org.junit.Assert;
import org.junit.Test;

public class EmbeddedThumbnailImageTest {

    @Test
    public void name() {
        EmbeddedThumbnailImage embeddedThumbnailImage = new EmbeddedThumbnailImage();
        embeddedThumbnailImage.setName("hello.png");
        embeddedThumbnailImage.setImageExtension(embeddedThumbnailImage.extensionExtract(embeddedThumbnailImage.getName()));
        embeddedThumbnailImage.setData("someBase64==");
        Assert.assertEquals("PNG", embeddedThumbnailImage.getImageType());
        Assert.assertEquals("data:image/png;base64, someBase64==", embeddedThumbnailImage.getImageSource());
        Assert.assertEquals(".png", embeddedThumbnailImage.getImageExtension());
    }

    @Test
    public void name2() {
        EmbeddedThumbnailImage embeddedThumbnailImage = new EmbeddedThumbnailImage();
        embeddedThumbnailImage.setName("hello.png.jpeg");
        embeddedThumbnailImage.setImageExtension(embeddedThumbnailImage.extensionExtract(embeddedThumbnailImage.getName()));
        embeddedThumbnailImage.setData("someBase64==");
        Assert.assertEquals(".jpeg", embeddedThumbnailImage.getImageExtension());
        Assert.assertEquals("data:image/jpeg;base64, someBase64==", embeddedThumbnailImage.getImageSource());
        Assert.assertEquals("JPEG", embeddedThumbnailImage.getImageType());
    }

    @Test(expected = FileThumbnailImage.FileNameIsNotContainExtension.class)
    public void name3() {
        EmbeddedThumbnailImage embeddedThumbnailImage = new EmbeddedThumbnailImage();
        embeddedThumbnailImage.setName("hellopngjpeg");
    }
}