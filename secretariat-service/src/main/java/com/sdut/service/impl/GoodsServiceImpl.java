package com.sdut.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sdut.entity.Goods;
import com.sdut.mapper.GoodsMapper;
import com.sdut.service.GoodsService;
import com.sdut.utils.PageFactory;
import com.sdut.utils.ResV;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author springforest
 * @description 针对表【goods(物资)】的数据库操作Service实现
 * @createDate 2022-11-13 09:38:38
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods>
        implements GoodsService {

    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public ResV getGoodsByName(String name, int pageSize, int pageNum) {
        Page<Goods> page = new Page<>(pageNum, pageSize);

        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", name);

        try {
            goodsMapper.selectPage(page, queryWrapper);
        } catch (Exception e) {
            System.out.println(e);
            return ResV.error(e.toString());
        }

        return ResV.ok(PageFactory.getPageInfo(page));
    }

    @Override
    public ResV add(Goods goods) {
        try {
            goodsMapper.insert(goods);
        } catch (Exception e) {
            System.out.println(e);
            return ResV.error(e.toString());
        }
        return ResV.ok();
    }

    @Override
    public ResV remove(int id) {
        try {
            goodsMapper.deleteById(id);
        } catch (Exception e) {
            System.out.println(e);
            return ResV.error(e.toString());
        }
        return ResV.ok();
    }

    @Override
    public ResV update(Goods goods) {
        try {
            goodsMapper.updateById(goods);
        } catch (Exception e) {
            System.out.println(e);
            return ResV.error(e.toString());
        }
        return ResV.ok();
    }
}




