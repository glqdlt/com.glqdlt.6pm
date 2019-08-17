package com.glqdlt.pm6.webservice.entity.book;

import com.glqdlt.pm6.webservice.entity.upload.ThumbnailImage;

import java.time.LocalDateTime;

/**
 * Date 2019-08-17
 *
 * @author glqdlt
 */
public class Book {
    private Long id;
    private String title;
    private Author author;
    private LocalDateTime regDate;
    private ThumbnailImage thumbnailImage;
}
