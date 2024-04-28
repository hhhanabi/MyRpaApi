package com.example.myrpaapi.security;

import com.example.myrpaapi.entity.User;
import com.example.myrpaapi.service.MenuService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class UserDetailsImpl implements UserDetails {

    private final User user;

    @Resource
    MenuService menuService;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        Set<GrantedAuthority> perms = new HashSet<>();
//        if(user.getUsername().equals("admin")) {
//            perms.add(new SimpleGrantedAuthority("`*:*:*"));
//        } else {
//            List<String> permissions = (List<String>) menuService.selectMenuPermsByUserId(user);
//            for (String perm : permissions) {
//                perms.add(new SimpleGrantedAuthority(perm));
//            }
//        }
//        return perms.stream().toList();
        return null;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
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
        return true;
    }
}
