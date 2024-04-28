package com.example.myrpaapi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.myrpaapi.entity.Menu;
import com.example.myrpaapi.entity.User;

import java.util.Collection;

/**
 * (Menu)表服务接口
 *
 * @author Troy
 * @since 2024-04-22 15:59:56
 */
public interface MenuService extends IService<Menu> {

    Collection<String> selectMenuPermsByUserId(User user);
}

