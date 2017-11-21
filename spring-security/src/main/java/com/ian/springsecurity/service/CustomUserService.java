package com.ian.springsecurity.service;


import com.ian.springsecurity.dao.SysUserRepository;
import com.ian.springsecurity.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserService implements UserDetailsService {

    @Autowired
    private SysUserRepository sur;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = sur.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        return user;
    }
}
