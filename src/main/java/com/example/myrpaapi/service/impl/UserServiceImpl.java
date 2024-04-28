package com.example.myrpaapi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.myrpaapi.dao.UserDao;
import com.example.myrpaapi.entity.Role;
import com.example.myrpaapi.entity.User;
import com.example.myrpaapi.enumerate.RoleType;
import com.example.myrpaapi.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao,User> implements UserService {
    @Resource
    PasswordEncoder passwordEncoder;
    @Override
    public User getUserByName(String userName) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(User::getUsername,userName);
        User user =this.getOne(wrapper);
        if (Objects.isNull(user)) {
            throw new RuntimeException("用户不存在");
        }

//        List<Role> roles = List.of(new Role(RoleType.ADMIN), new Role(RoleType.USER));
//        List<Role> roles = List.of( new Role(RoleType.USER));
        return user;

    }
}
