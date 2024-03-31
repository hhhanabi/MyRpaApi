package com.example.myrpaapi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.myrpaapi.dao.FileDao;
import com.example.myrpaapi.entity.File;
import com.example.myrpaapi.service.FileService;
import org.springframework.stereotype.Service;

/**
 * (File)表服务实现类
 *
 * @author makejava
 * @since 2024-03-31 16:47:51
 */
@Service("fileService")
public class FileServiceImpl extends ServiceImpl<FileDao, File> implements FileService {

}

