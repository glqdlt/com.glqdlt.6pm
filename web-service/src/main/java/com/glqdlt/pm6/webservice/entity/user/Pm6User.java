package com.glqdlt.pm6.webservice.entity.user;

import java.time.LocalDateTime;

/**
 * Date 2019-08-04
 *
 * @author glqdlt
 */
public class Pm6User extends User {
    private Integer level;
    private Long point;
    private Long exp;
    private LocalDateTime joinDate;
    private String nickname;
    private Boolean lock;
    private String thumbnail;
}
