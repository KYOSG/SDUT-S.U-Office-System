package com.sdut.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sdut.entity.BorrowInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author springforest
 * @description 针对表【borrowInfo(借用登记表)】的数据库操作Mapper
 * @createDate 2022-11-13 11:41:50
 * @Entity sdut.sdut.BorrowInfo
 */
@Mapper
public interface BorrowInfoMapper extends BaseMapper<BorrowInfo> {

}




