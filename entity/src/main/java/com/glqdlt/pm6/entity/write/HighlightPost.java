package com.glqdlt.pm6.entity.write;

import java.time.LocalDateTime;

/**
 * Date 2019-08-04
 *
 * @author glqdlt
 */
public class HighlightPost extends Post implements Expire {
    private Integer priority;
    private LocalDateTime expireTime;

    @Override
    public void setExpireDate(LocalDateTime expireDate) {
        this.expireTime = expireDate;
    }

    @Override
    public LocalDateTime getExpireDate() {
        return expireTime;
    }
}
