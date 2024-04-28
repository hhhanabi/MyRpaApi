package com.example.myrpaapi.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends Model<User> {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String username;
    private String password;
    @TableField(exist = false)
    private List<Role> roles;
}