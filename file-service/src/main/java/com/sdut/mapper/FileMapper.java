package com.sdut.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sdut.entity.File;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author springforest
 * @description 针对表【file(文件)】的数据库操作Mapper
 * @createDate 2023-01-08 10:37:12
 * @Entity .sdut.file
 */
public interface FileMapper extends BaseMapper<File> {
    public void insertBatch(@Param("list") List<File> list);
}




