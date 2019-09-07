package com.glqdlt.pm6.entity.user.log;

import java.time.LocalDateTime;

/**
 * Date 2019-08-10
 *
 * @author glqdlt
 */
public interface Log {
    Long getSeq();

    void setSeq(Long seq);

    LocalDateTime getRegistrationDate();

    void setRegistrationDate();
}
