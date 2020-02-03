package com.glqdlt.pm6.api.model.authority;

public class SimpleTextAuthority implements GrantedAuthority {
    private String authority;
    @Override
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
