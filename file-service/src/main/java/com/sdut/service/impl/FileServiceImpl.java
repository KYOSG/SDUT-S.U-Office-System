package com.sdut.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sdut.entity.File;
import com.sdut.mapper.FileMapper;
import com.sdut.service.FileService;
import com.sdut.utils.ResV;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author springforest
 * @description 针对表【file(文件)】的数据库操作Service实现
 * @createDate 2023-01-08 10:37:12
 */
@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, File>
        implements FileService {
    private static final Logger logger = (Logger) LoggerFactory.getLogger("FileUploadServiceImpl");

    @Resource
    private FileMapper fileMapper;

    @Override
    public ResV uploadFile(List<MultipartFile> fileList) {
        //遍历上传的文件
        List<File> list = new ArrayList<>();
        for (MultipartFile file : fileList) {
            File filEntity = new File();

            //获取文件名
            String originalFileName = file.getOriginalFilename();
            filEntity.setFileOriginName(originalFileName);
            logger.info(originalFileName);

            //获取文件大小（无用，仅测试）
            long fileSize = file.getSize();
            if (fileSize < 1024) {
                logger.info(fileSize + "B");
            } else if (fileSize / 1024 < 1024) {
                logger.info(fileSize / 1024 + "KB");
            } else if (fileSize / 1024 / 1024 < 1024) {

                logger.info(fileSize / 1024 / 1024 + "MB");
            } else if (fileSize / 1024 / 1024 / 1024 < 1024) {
                logger.info(fileSize / 1024 / 1024 / 1024 + "GB");
            }
            filEntity.setFileSize(BigDecimal.valueOf(fileSize / 1024 / 1024));

            //文件重命名
            assert originalFileName != null;
            String ext = "." + originalFileName.split("\\.")[1];
            String uuid = UUID.randomUUID().toString().replace("-", "");
            String newFileName = uuid + ext;
            filEntity.setFileName(newFileName);
            //指定文件存储路径
            //存储图片至当前运行路径/resource/images文件夹下
            ApplicationHome applicationHome = new ApplicationHome(this.getClass());
            String pre = applicationHome.getDir().getParentFile().getParentFile().getAbsolutePath() + "/src/main/resources/images/";
            String path = pre + newFileName;
            filEntity.setFilePath(path);
            logger.debug("文件路径：" + path);

            //存储文件
            try {
                file.transferTo(new java.io.File(path));
                list.add(filEntity);
            } catch (Exception e) {
                e.printStackTrace();
                return ResV.error(e.toString());
            }
        }

        try {
            fileMapper.insertBatch(list);
        } catch (Exception e) {
            e.printStackTrace();
            return ResV.error("文件保存至数据库出错");
        }

        return ResV.ok();
    }
}




