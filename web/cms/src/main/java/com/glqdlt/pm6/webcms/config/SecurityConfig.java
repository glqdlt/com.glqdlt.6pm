package com.glqdlt.pm6.webcms.config;

import com.glqdlt.pm6.jpapersistence.user.repo.Pm6UserRepo;
import com.glqdlt.pm6.security.Pm6UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.vote.AuthenticatedVoter;
import org.springframework.security.access.vote.UnanimousBased;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.expression.WebExpressionVoter;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

/**
 * Date 2019-11-17
 *
 * @author glqdlt
 */
@Slf4j
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@ConditionalOnProperty(name = "pm6.security.enable", havingValue = "true")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;


    @Bean
    public UserDetailsService userDetailsService(@Autowired Pm6UserRepo pm6UserRepo) {
        return new Pm6UserServiceImpl(pm6UserRepo);
    }

    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return userDetailsService;
    }

    /**
     * WebSecurity 는 HttpSecurity 를 태울지 말지를 결정하는 서블릿 리퀘스트 최앞단의 필터이다.
     * HttpSecurity에도 permitAll이라는 게 있지만, 다른 matcher 들이 통과하고 난 이후에 조건절에 걸림으로 성능상의 차이가 매우 난다.
     * /image/** 의 경우 cors 가 고려되야 하기 때문에 httpSecurity 로 태운다.
     *
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/webjars/**", "/static/**", "/h2-console/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = http
                .cors()
                .configurationSource(new UrlBasedCorsConfigurationSource())
                .and()
                .csrf()
                .csrfTokenRepository(new HttpSessionCsrfTokenRepository())
                .and()
                .formLogin()
                .and()
                .authorizeRequests()
                .antMatchers("/image/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .accessDecisionManager(accessDecisionManager());
    }

    @Bean
    public AccessDecisionManager accessDecisionManager() {
        return new UnanimousBased(Arrays.asList(new WebExpressionVoter(), new AuthenticatedVoter(), new InMemoryAuthorizeMapDynamicAccessVoter(new AuthorizrUrlMapStore())));
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
//        FIXME 개발단계여서 평문으로 처리하게 해둠
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return s.equals(charSequence.toString());
            }
        };
    }
}
