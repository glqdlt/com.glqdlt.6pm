package com.glqdlt.pm6.security;

import com.glqdlt.pm6.api.model.user.Pm6User;
import com.glqdlt.pm6.persistence.user.entity.Pm6GrantEntity;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Date 2019-11-17
 *
 * @author glqdlt
 */
public class Pm6UserDetail implements UserDetails {

    private Pm6User<Pm6GrantEntity> reference;
    private Collection<Pm6GrantSpringSecurityBridge> grant;

    public Pm6UserDetail(Pm6User<Pm6GrantEntity> ref) {
        this.reference = ref;
        this.grant = ref.getGrant().stream().map(Pm6GrantSpringSecurityBridge::new)
                .collect(Collectors.toList());
    }

    public Pm6User getReference() {
        return reference;
    }

    @Override
    public Collection<Pm6GrantSpringSecurityBridge> getAuthorities() {
        return grant;
    }

    @Override
    public String getPassword() {
        return getReference().getPassword();
    }

    @Override
    public String getUsername() {
        return getReference().getId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return !getReference().isLock();
    }

    @Override
    public boolean isAccountNonLocked() {
        return !getReference().isLock();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !getReference().isLock();
    }

    @Override
    public boolean isEnabled() {
        return !getReference().isLock();
    }
}
