package com.glqdlt.pm6.webservice.entity.upload;

import org.junit.Assert;
import org.junit.Test;

public class LinkThumbnailImageTest {

    @Test
    public void name() {
        LinkThumbnailImage linkThumbnailImage = new LinkThumbnailImage();
        linkThumbnailImage.setUrl("https://bookthumb-phinf.pstatic.net/cover/107/710/10771065.jpg?type=m140&udate=20160721");

        Assert.assertEquals("https://bookthumb-phinf.pstatic.net/cover/107/710/10771065.jpg?type=m140&udate=20160721", linkThumbnailImage.getImageSource());
        Assert.assertEquals("https://bookthumb-phinf.pstatic.net/cover/107/710/10771065.jpg?type=m140&udate=20160721", linkThumbnailImage.getLinkUrl());

    }
}