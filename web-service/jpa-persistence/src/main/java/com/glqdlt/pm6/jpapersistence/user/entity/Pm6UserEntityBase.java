package com.glqdlt.pm6.jpapersistence.user.entity;

import com.glqdlt.general.api.model.EntityModel;
import com.glqdlt.pm6.api.model.user.Pm6User;

import javax.persistence.Transient;
import java.time.LocalDateTime;

/**
 * Date 2019-11-17
 *
 * @author glqdlt
 */
public abstract class Pm6UserEntityBase implements Pm6User<Pm6GrantEntity>, EntityModel {
    private String userName;
    private String userId;
    private Long userNo;
    private String userEmail;
    private String userPassword;
    private Boolean userLock;
    private LocalDateTime regDate;

    @Override
    public Boolean isLock() {
        return getUserLock();
    }

    @Transient
    @Override
    public Long getNo() {
        return getUserNo();
    }

    @Transient
    @Override
    public String getId() {
        return getUserId();
    }

    @Transient
    @Override
    public String getPassword() {
        return getUserPassword();
    }

    @Transient
    @Override
    public String getEmail() {
        return getUserEmail();
    }

    @Override
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getUserNo() {
        return userNo;
    }

    public void setUserNo(Long userNo) {
        this.userNo = userNo;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Boolean getUserLock() {
        return userLock;
    }

    public void setUserLock(Boolean userLock) {
        this.userLock = userLock;
    }

    @Override
    public LocalDateTime getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDateTime regDate) {
        this.regDate = regDate;
    }
}
