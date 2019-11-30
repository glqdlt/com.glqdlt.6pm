package com.glqdlt.pm6.api.model.user;

import com.glqdlt.pm6.api.model.authencation.Pm6Grant;

import java.util.List;

/**
 * Date 2019-11-10
 *
 * @author glqdlt
 */
public interface Pm6User<G extends Pm6Grant> extends User {
    String getUserName();

    Boolean isLock();

    List<G> getGrant();
}
