package com.glqdlt.pm6.api.model.authority;

public class RoleBaseAuthority implements GrantedAuthority {
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return "ROLE_" + getRole();
    }
}
