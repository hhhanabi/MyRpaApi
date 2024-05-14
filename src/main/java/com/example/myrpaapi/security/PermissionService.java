package com.example.myrpaapi.security;

import com.example.myrpaapi.dao.PermissionDao;
import com.example.myrpaapi.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

@Service("ss")
public class PermissionService {
    @Resource
    UserService userService;
    @Resource
    PermissionDao permissionDao;
    /**
     * 验证用户是否具备某权限
     *
     * @param permission 权限字符串
     * @return 用户是否具备某权限
     */
    public boolean hasPermi(String permission) {
        if (StringUtils.isEmpty(permission)) {
            return false;
        }
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (username.equals("admin")) {
            return true;
        }
        Integer user_id = userService.selectIDByName(username);
        return permissionDao.getPermissionListByID(user_id).contains(permission);
    }
}