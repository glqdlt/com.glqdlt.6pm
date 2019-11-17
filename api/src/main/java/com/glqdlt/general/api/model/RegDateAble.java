package com.glqdlt.general.api.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Date 2019-11-10
 *
 * @author glqdlt
 */
public interface RegDateAble {
    LocalDateTime getRegDate();
    default String getRegDateFormatString(){
        LocalDateTime date = getRegDate();
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
