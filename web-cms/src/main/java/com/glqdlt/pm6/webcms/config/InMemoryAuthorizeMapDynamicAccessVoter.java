package com.glqdlt.pm6.webcms.config;

import com.glqdlt.pm6.api.model.authencation.GrantAttribute;
import com.glqdlt.pm6.security.Pm6GrantSpringSecurityBridge;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Date 2019-11-30
 *
 * @author glqdlt
 * @see <a href='https://www.baeldung.com/spring-security-custom-voter'>https://www.baeldung.com/spring-security-custom-voter</a>
 */
@Slf4j
public class InMemoryAuthorizeMapDynamicAccessVoter implements AccessDecisionVoter<FilterInvocation> {

    private static final String[] SKIP_ATTRIBUTES = {"permitAll", "denyAll", "anonymous"};

    private AuthorizrUrlMapStore authorizrUrlMapStore;

    public InMemoryAuthorizeMapDynamicAccessVoter(AuthorizrUrlMapStore authorizrUrlMapStore) {
        this.authorizrUrlMapStore = authorizrUrlMapStore;
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
//        FIXME 아래처럼 Attribute 가 Expression 인 경우를 체크해야하는데, 접근제어자가 public 이 아니다.
//         더군다나 getAttribute 를 하면 null로 나온다. 어떻게 permitAll 인 걸 체크해야하나?
//        if (attribute instanceof WebExpressionConfigAttribute);
//        or attribute.getAttribvute().eqault("permitAll");
        return true;
    }

    @Override
    public int vote(Authentication authentication, FilterInvocation request, Collection<ConfigAttribute> attributes) {
        if (authentication == null) {
            return ACCESS_DENIED;
        }

        if (!authentication.isAuthenticated()) {
            return ACCESS_DENIED;
        }

        String reqeustUrl = request.getRequestUrl();
        ProtectEndpointUrl ee;
        try {
            ee = authorizrUrlMapStore.match(reqeustUrl);
        } catch (NotMatchedItem e) {
            log.warn(e.getMessage());
            return ACCESS_ABSTAIN;
        }
        List<GrantedAuthority> eeeee = new ArrayList<>(authentication.getAuthorities());



        return ACCESS_ABSTAIN;
    }


    @Override
    public boolean supports(Class clazz) {
        return clazz.equals(FilterInvocation.class);
    }
}
