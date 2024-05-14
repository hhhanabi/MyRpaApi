package com.example.myrpaapi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.myrpaapi.entity.User;

public interface UserService extends IService<User> {
    User getUserByName(String userName);

    Integer selectIDByName(String username);
}
