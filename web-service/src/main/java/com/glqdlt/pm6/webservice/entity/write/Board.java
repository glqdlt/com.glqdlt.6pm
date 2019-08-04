package com.glqdlt.pm6.webservice.entity.write;

import java.time.LocalDateTime;

/**
 * Date 2019-08-04
 *
 * @author glqdlt
 */
public class Board {
    private String name;
    private LocalDateTime createdTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }
}
