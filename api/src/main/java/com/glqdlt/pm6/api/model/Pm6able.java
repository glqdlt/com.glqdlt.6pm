package com.glqdlt.pm6.api.model;

import java.time.LocalDateTime;

/**
 * Date 2019-11-10
 *
 * @author glqdlt
 */
public interface Pm6able extends UniqueNumber {
    LocalDateTime getRegDate();
}
