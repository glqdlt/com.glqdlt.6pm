package com.glqdlt.pm6.entity.write;

import com.glqdlt.pm6.model.write.Writeable;

/**
 * Date 2019-08-04
 *
 * @author glqdlt
 */
public class Post extends Writeable {
    private String title;
    private Long viewCount;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getViewCount() {
        return viewCount;
    }

    public void setViewCount(Long viewCount) {
        this.viewCount = viewCount;
    }
}
