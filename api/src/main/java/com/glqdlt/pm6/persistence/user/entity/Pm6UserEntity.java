package com.glqdlt.pm6.persistence.user.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Date 2019-11-17
 *
 * @author glqdlt
 */
@Entity
@Table(name = "tb_member")
public class Pm6UserEntity extends Pm6UserEntityBase{

    @Transient
    @Override
    public String getRegDateFormatString() {
        return super.getRegDateFormatString();
    }
    @Transient
    @Override
    public Long getNo() {
        return super.getNo();
    }
    @Transient
    @Override
    public String getId() {
        return super.getId();
    }
    @Transient
    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Transient
    @Override
    public String getEmail() {
        return super.getEmail();
    }


    @Override
    public String getUserName() {
        return super.getUserName();
    }

    @Column(unique = true)
    @Override
    public String getUserId() {
        return super.getUserId();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "no")
    @Override
    public Long getUserNo() {
        return super.getUserNo();
    }

    @Column(unique = true)
    @Override
    public String getUserEmail() {
        return super.getUserEmail();
    }

    @Override
    public String getUserPassword() {
        return super.getUserPassword();
    }

    @Override
    public Boolean getUserLock() {
        return super.getUserLock();
    }

    @Override
    public LocalDateTime getRegDate() {
        return super.getRegDate();
    }
}
