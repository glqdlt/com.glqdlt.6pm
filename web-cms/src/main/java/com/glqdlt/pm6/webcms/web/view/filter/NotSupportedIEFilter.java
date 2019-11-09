package com.glqdlt.pm6.webcms.web.view.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

/**
 * Date 2019-08-10
 *
 * @author glqdlt
 * @see <a href='https://www.baeldung.com/spring-boot-add-filter'>https://www.baeldung.com/spring-boot-add-filter</a>
 */
public class NotSupportedIEFilter implements Filter {
    private final static Logger logger = LoggerFactory.getLogger(NotSupportedIEFilter.class);
    private final static String HEADER_USER_AGENT = "user-agent";
    private final static String MS_ENGINE = "Trident";
    private final String redirectPath;
    private String excludePathRegex;

    public NotSupportedIEFilter(String redirectUrl) {
        this.redirectPath = redirectUrl;
    }

    public NotSupportedIEFilter(String redirectUrl, String excludePattern) {
        this.redirectPath = redirectUrl;
        this.excludePathRegex = excludePattern;
    }

    public String getExcludePathRegex() {
        return excludePathRegex;
    }

    public static String getHeaderUserAgent() {
        return HEADER_USER_AGENT;
    }

    public String getRedirectPath() {
        return redirectPath;
    }

    public void setExcludePathRegex(String excludePathRegex) {
        this.excludePathRegex = excludePathRegex;
    }

    private boolean isExcludeUrl(String requestUri) {

        if (requestUri.equals(getRedirectPath())) {
            return false;
        }

        if (getExcludePathRegex() == null) {
            return true;
        }
        return !requestUri.matches(getExcludePathRegex());
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = ((HttpServletRequest) request);
        String req = httpServletRequest.getRequestURI();
        if (isExcludeUrl(req)) {
            String optionalUserAgent = httpServletRequest.getHeader(getHeaderUserAgent());
            if (optionalUserAgent != null) {
                if (optionalUserAgent.contains(MS_ENGINE)) {
                    logger.warn("Waring : User Agent is {}, It's maybe IE Browser.", MS_ENGINE);
                    ((HttpServletResponse) response).sendRedirect(getRedirectPath());
                    return;
                }
            }
        }
        chain.doFilter(request, response);
    }
}
