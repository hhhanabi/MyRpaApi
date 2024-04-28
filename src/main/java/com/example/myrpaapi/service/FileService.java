package com.example.myrpaapi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.myrpaapi.constant.ResultJson;
import com.example.myrpaapi.entity.File;

/**
 * (File)表服务接口
 *
 * @author makejava
 * @since 2024-03-31 16:47:51
 */
public interface FileService extends IService<File> {

    ResultJson<?> deleteFileByID(String id);
}

