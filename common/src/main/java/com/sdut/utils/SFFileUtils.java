package com.sdut.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;


public class SFFileUtils {
    /*
     * 文件全名
     * */
    private String fileName;
    /*
     * 文件后缀
     * */
    private String ext;
    /*
     * UUID
     * */
    private String uuid;
    /*
     * 源文件
     * */
    private MultipartFile multipartFile;
    /*
     * 转化后的File文件
     * */
    private File file;

    public SFFileUtils(MultipartFile rawFile) {
        this.fileName = rawFile.getOriginalFilename();
        this.ext = getExt(rawFile);
        this.multipartFile = rawFile;

        /*
          MultipartFile 转 File
         */
        //选择用缓冲区来实现这个转换即使用java 创建的临时文件 使用 MultipartFile.transferto()方法 。
        File file = null;
        try {
            //处理文件名
            String originalFilename = multipartFile.getOriginalFilename();
            assert originalFilename != null;
            String[] filename = originalFilename.split("\\.");
            this.createUUID();

            //将MultipartFile转换成File
            file = File.createTempFile(filename[0], filename[1] + ".");
            multipartFile.transferTo(file);
            file.deleteOnExit();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.file = file;
    }

    /*
     * 获取文件后缀
     * */
    private String getExt(MultipartFile file) {
        return "." + fileName.split("\\.")[1];
    }

    /*
     * 生成不重复的文件名
     * */
    private void createUUID() {
        this.uuid = UUID.randomUUID().toString().replace("-", "") + this.ext;
    }

    public File getFile() {
        return file;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getExt() {
        return this.ext;
    }

    public String getPostfix() {
        return this.ext;
    }

    public String getUUID() {
        return this.uuid;
    }

}
