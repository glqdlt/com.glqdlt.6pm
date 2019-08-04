package com.glqdlt.pm6.webservice.entity.write;

import com.glqdlt.pm6.webservice.entity.user.User;

import java.time.LocalDateTime;

/**
 * Date 2019-08-04
 *
 * @author glqdlt
 */
public class Write {
    private Long id;
    private String text;
    private LocalDateTime regDate;
    private Boolean viewable;
    private User author;
}
