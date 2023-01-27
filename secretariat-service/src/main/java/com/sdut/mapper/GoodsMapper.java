package com.sdut.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sdut.entity.Goods;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author springforest
 * @description 针对表【goods(物资)】的数据库操作Mapper
 * @createDate 2022-11-13 09:38:38
 * @Entity com.sdut.Entity.Goods
 */
@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {

}




