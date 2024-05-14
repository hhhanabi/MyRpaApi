package com.example.myrpaapi.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * (File)表实体类
 *
 * @author makejava
 * @since 2024-03-31 16:47:51
 */
@SuppressWarnings("serial")
@Data
public class File extends Model<File> {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String url;

    private String description;

    private String name;

    private Integer user_id;

}

