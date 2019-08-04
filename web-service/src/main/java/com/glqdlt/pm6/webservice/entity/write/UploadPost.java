package com.glqdlt.pm6.webservice.entity.write;

import java.util.List;

/**
 * Date 2019-08-04
 *
 * @author glqdlt
 */
public class UploadPost extends Post {
    private List<Upload> uploads;

    public List<Upload> getUploads() {
        return uploads;
    }

    public void setUploads(List<Upload> uploads) {
        this.uploads = uploads;
    }
}
