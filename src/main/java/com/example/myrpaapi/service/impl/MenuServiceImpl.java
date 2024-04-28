package com.example.myrpaapi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.myrpaapi.dao.MenuDao;
import com.example.myrpaapi.entity.Menu;
import com.example.myrpaapi.entity.User;
import com.example.myrpaapi.service.MenuService;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * (Menu)表服务实现类
 *
 * @author Troy
 * @since 2024-04-22 15:59:56
 */
@Service("menuService")
public class MenuServiceImpl extends ServiceImpl<MenuDao, Menu> implements MenuService {

    @Override
    public Collection<String> selectMenuPermsByUserId(User user) {
        return null;
    }
}

