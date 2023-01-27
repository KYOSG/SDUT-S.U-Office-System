package com.sdut.controller;

import com.sdut.service.FileService;
import com.sdut.utils.ResV;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Projectname: Cloud
 * @Filename: UploadController
 * @Author: SpringForest
 * @Data:2022/11/27 20:32
 * @Description:
 */

@RestController
@RequestMapping("/file")
public class FileUploadController {

    @Resource
    private FileService fileService;

    @RequestMapping("/upload")
    @ResponseBody
    public ResV upload(List<MultipartFile> fileList, HttpServletRequest request) {
        if (fileList == null || fileList.isEmpty()) {
            return ResV.error("您传了个寂寞");
        }

        return fileService.uploadFile(fileList);
    }
}
