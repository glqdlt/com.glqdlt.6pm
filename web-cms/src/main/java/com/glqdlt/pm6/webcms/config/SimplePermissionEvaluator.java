package com.glqdlt.pm6.webcms.config;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;

import java.io.Serializable;

/**
 * Date 2019-11-30
 *
 * @author glqdlt
 * @see <a href='https://www.baeldung.com/spring-security-create-new-custom-security-expression'>https://www.baeldung.com/spring-security-create-new-custom-security-expression</a>
 * @see <a href='https://docs.spring.io/spring-security/site/docs/3.0.x/reference/el-access.html'>https://docs.spring.io/spring-security/site/docs/3.0.x/reference/el-access.html</a>
 */
public class SimplePermissionEvaluator implements PermissionEvaluator {
    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        return false;
    }
}
