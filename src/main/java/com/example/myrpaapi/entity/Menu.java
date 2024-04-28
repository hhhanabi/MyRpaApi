package com.example.myrpaapi.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
/**
 * (Menu)表实体类
 *
 * @author Troy
 * @since 2024-04-22 15:59:56
 */
@Getter
@Setter
public class Menu extends Model<Menu> {

    private Integer id;

    private String perms;

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    public Serializable pkVal() {
        return this.id;
    }
}

