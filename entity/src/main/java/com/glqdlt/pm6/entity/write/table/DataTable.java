package com.glqdlt.pm6.entity.write.table;

import com.glqdlt.pm6.model.write.Writeable;

/**
 * Date 2019-08-17
 *
 * @author glqdlt
 */
@Deprecated
public class DataTable extends Writeable {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
