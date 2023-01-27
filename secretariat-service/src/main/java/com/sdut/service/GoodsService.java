package com.sdut.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sdut.entity.Goods;
import com.sdut.utils.ResV;

/**
 * @author springforest
 * @description 针对表【goods(物资)】的数据库操作Service
 * @createDate 2022-11-13 09:38:38
 */
public interface GoodsService extends IService<Goods> {
    public ResV getGoodsByName(String name, int pageSize, int pageNum);

    public ResV add(Goods goods);

    public ResV remove(int id);

    public ResV update(Goods goods);
}
