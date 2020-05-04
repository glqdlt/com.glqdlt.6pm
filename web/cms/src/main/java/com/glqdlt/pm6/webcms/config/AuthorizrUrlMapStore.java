package com.glqdlt.pm6.webcms.config;

import com.glqdlt.pm6.api.model.authencation.GrantAttribute;

import java.util.LinkedList;
import java.util.List;

/**
 * Date 2019-11-30
 *
 * @author glqdlt
 */
public class AuthorizrUrlMapStore {
    private final List<ProtectEndpointUrl> map = new LinkedList<>();

    public AuthorizrUrlMapStore() {
        map.add(new ProtectEndpointUrl() {
            @Override
            public String getEndpointUrl() {
                return "/image/";
            }

            @Override
            public Integer getProtectedType() {
                return 0;
            }

            @Override
            public List<GrantAttribute> getAuthorityAttributes() {
                return null;
            }

            @Override
            public boolean isSupportedUrl(String url) {
                return url.startsWith(getEndpointUrl());
            }

            @Override
            public boolean evaluate(List<GrantAttribute> targetUserAttribute) {
                return true;
            }
        });
    }

    public ProtectEndpointUrl match(String requestUrl) {
        return map.stream().filter(x -> x.isSupportedUrl(requestUrl))
                .findAny().orElseThrow(() -> new NotMatchedItem(String.format("Not Matched Item : %s", requestUrl)));

    }

    public void reload() {

    }
}