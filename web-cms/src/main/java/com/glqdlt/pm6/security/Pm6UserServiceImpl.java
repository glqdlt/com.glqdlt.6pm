package com.glqdlt.pm6.security;

import com.glqdlt.pm6.persistence.user.entity.Pm6UserEntity;
import com.glqdlt.pm6.persistence.user.repo.Pm6UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Date 2019-11-17
 *
 * @author glqdlt
 */
public class Pm6UserServiceImpl implements UserDetailsService {

    private Pm6UserRepo pm6UserRepo;

    public Pm6UserServiceImpl(Pm6UserRepo pm6UserRepo) {
        this.pm6UserRepo = pm6UserRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Pm6UserEntity existUser = pm6UserRepo.findByUserId(s)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("Not found user '%s'", s)));
        return new Pm6UserDetail(existUser);
    }


}
