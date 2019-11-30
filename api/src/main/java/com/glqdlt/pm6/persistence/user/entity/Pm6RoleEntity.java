package com.glqdlt.pm6.persistence.user.entity;

import javax.persistence.DiscriminatorValue;

/**
 * Date 2019-11-30
 *
 * @author glqdlt
 */
@DiscriminatorValue("R")
public class Pm6RoleEntity extends Pm6GrantEntity {

    @Override
    public String getAttributeName() {
        return "ROLE";
    }
}
