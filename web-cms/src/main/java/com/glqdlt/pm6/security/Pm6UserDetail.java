package com.glqdlt.pm6.security;

import com.glqdlt.pm6.api.model.user.Pm6User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Date 2019-11-17
 *
 * @author glqdlt
 */
public class Pm6UserDetail implements UserDetails {

    private Pm6User reference;

    public Pm6UserDetail(Pm6User ref) {
        this.reference = ref;
    }

    public Pm6User getReference() {
        return reference;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
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
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return !getReference().isLock();
    }
}
