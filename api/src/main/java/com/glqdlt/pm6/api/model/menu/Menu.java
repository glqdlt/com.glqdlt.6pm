package com.glqdlt.pm6.api.model.menu;

import com.glqdlt.pm6.api.model.authencation.GrantAttribute;

import java.util.List;

/**
 * Date 2019-12-01
 *
 * @author glqdlt
 */
public interface Menu<G extends GrantAttribute> {
    String getMenuName();

    String getUrlPath();

    List<G> getAccessGrant();
}
