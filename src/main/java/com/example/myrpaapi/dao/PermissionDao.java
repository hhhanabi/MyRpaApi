package com.example.myrpaapi.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

@Mapper
public interface PermissionDao {
    @Select("select perms from user u " +
            "join user_role ur on u.id=ur.user_id " +
            "join role r on ur.role_id=r.id " +
            "join role_menu rm on rm.role_id=r.id " +
            "join menu m on m.id=rm.menu_id " +
            "where u.id=#{user_id}")
    Set<String> getPermissionListByID(Integer user_id);
}
