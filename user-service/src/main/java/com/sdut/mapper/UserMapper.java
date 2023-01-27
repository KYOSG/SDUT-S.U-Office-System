package com.sdut.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sdut.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Projectname: Cloud
 * @Filename: UserMapper
 * @Author: SpringForest
 * @Data:2022/11/12 21:29
 * @Description:
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    public Page<User> getAllUser(Page<User> page);
}
