package com.glqdlt.pm6.persistence.user.entity;

import javax.persistence.DiscriminatorValue;

/**
 * Date 2019-11-30
 *
 * @author glqdlt
 */
@DiscriminatorValue("A")
public class Pm6AuthorityEntity extends Pm6GrantEntity {

    @Override
    public String getAttributeName() {
        return "AUTHORITY";
    }

}
