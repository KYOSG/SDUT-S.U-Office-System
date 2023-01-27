package com.sdut.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.sdut.entity.File;
import com.sdut.utils.ResV;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author springforest
 * @description 针对表【file(文件)】的数据库操作Service
 * @createDate 2023-01-08 10:37:12
 */
public interface FileService extends IService<File> {
    public ResV uploadFile(List<MultipartFile> fileList);
}
