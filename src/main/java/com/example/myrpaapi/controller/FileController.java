package com.example.myrpaapi.controller;

import com.example.myrpaapi.constant.ResultJson;
import com.example.myrpaapi.entity.File;
import com.example.myrpaapi.service.FileService;
import com.example.myrpaapi.util.FileUtil;
import jakarta.annotation.Resource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@RequestMapping("/file")
@RestController
public class FileController {
    @Resource
    FileService fileService;

    @PostMapping("/upload")
    public ResultJson<?> uploadFolder(@RequestParam("folderName") String folderName,MultipartFile file) throws IOException {
        String originalFileName = file.getOriginalFilename();
        String fileExtension = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
        if(fileExtension.equals("txt")) {
            String fileContent = new String(file.getBytes(), StandardCharsets.UTF_8);
            File dbFile = new File();
            dbFile.setUrl(folderName);
            dbFile.setDescription(fileContent);
            dbFile.setName(folderName);
            fileService.save(dbFile);
        }
        FileUtil.saveMultiFile("D:/upload/"+folderName, file);
        return ResultJson.ok();
    }
    @DeleteMapping
    public ResultJson<?> deleteFile(String id) {
        return fileService.deleteFileByID(id);
    }
    @GetMapping
    public ResultJson<?> getAll() {
        return ResultJson.ok(fileService.list());
    }

}
