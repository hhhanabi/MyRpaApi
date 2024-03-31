package com.example.myrpaapi.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * (File)表实体类
 *
 * @author makejava
 * @since 2024-03-31 16:47:51
 */
@SuppressWarnings("serial")
public class File extends Model<File> {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String url;

    private String description;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

