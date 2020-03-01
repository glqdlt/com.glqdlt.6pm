package com.glqdlt.pm6.security;

import com.glqdlt.pm6.api.model.authencation.Pm6Grant;
import org.springframework.security.core.GrantedAuthority;

/**
 * Date 2019-11-30
 *
 * @author glqdlt
 */
public class Pm6GrantSpringSecurityBridge<G extends Pm6Grant> implements GrantedAuthority {
    private G pm6Grant;

    public Pm6GrantSpringSecurityBridge(G ref) {
        this.pm6Grant = ref;
    }

    @Override
    public String getAuthority() {
        return pm6Grant.getAttributeValue();
    }

    public G getPm6Grant() {
        return pm6Grant;
    }
}
