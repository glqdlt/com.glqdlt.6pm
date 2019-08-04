package com.glqdlt.pm6.webservice.entity.write;

import java.time.LocalDateTime;

/**
 * Date 2019-08-04
 *
 * @author glqdlt
 */
public interface Expire {
    void setExpireDate(LocalDateTime expireDate);
    LocalDateTime getExpireDate();
}
