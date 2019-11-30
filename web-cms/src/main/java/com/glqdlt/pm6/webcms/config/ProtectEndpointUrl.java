package com.glqdlt.pm6.webcms.config;

import com.glqdlt.pm6.api.model.authencation.GrantAttribute;

import java.util.List;

/**
 * Date 2019-11-30
 *
 * @author glqdlt
 */
public interface ProtectEndpointUrl {

    String getEndpointUrl();

    Integer getProtectedType();

    List<GrantAttribute> getAuthorityAttributes();

    boolean isSupportedUrl(String url);

    boolean evaluate(List<GrantAttribute> targetUserAttribute);

}
