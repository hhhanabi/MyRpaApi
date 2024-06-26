package com.example.myrpaapi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.myrpaapi.constant.ResultCode;
import com.example.myrpaapi.constant.ResultJson;
import com.example.myrpaapi.dao.FileDao;
import com.example.myrpaapi.entity.File;
import com.example.myrpaapi.security.PermissionService;
import com.example.myrpaapi.service.FileService;
import jakarta.annotation.Resource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * (File)表服务实现类
 *
 * @author makejava
 * @since 2024-03-31 16:47:51
 */
@Service("fileService")
public class FileServiceImpl extends ServiceImpl<FileDao, File> implements FileService {
    @Resource
    PermissionService permissionService;
    @Override
    public ResultJson<?> deleteFileByID (String id) {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!permissionService.hasPermi("deleteApp"))  {
            return ResultJson.failure(ResultCode.FORBIDDEN);
        }
        if (this.removeById(id)) {
            return ResultJson.ok();
        } else {
            return ResultJson.failure(ResultCode.SERVER_ERROR);
        }
    }
}

