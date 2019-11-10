package com.glqdlt.pm6.api.model.user;

import java.time.LocalDateTime;

/**
 * Date 2019-08-04
 *
 * @author glqdlt
 */
public interface User {
    String getId();

    String getPassword();

    String getEmail();

    LocalDateTime getRegDate();
}
