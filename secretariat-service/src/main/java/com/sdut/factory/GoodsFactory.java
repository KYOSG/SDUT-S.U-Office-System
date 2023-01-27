package com.sdut.factory;

import com.alibaba.fastjson.JSONObject;
import com.sdut.entity.Goods;

/**
 * @Projectname: Cloud
 * @Filename: GoodsFactory
 * @Author: SpringForest
 * @Data:2022/11/13 09:46
 * @Description:
 */

public class GoodsFactory {
    public static Goods getGood(JSONObject jsonObject) {
        Goods goods = new Goods();
        goods.setId(jsonObject.getInteger("id"));
        goods.setName(jsonObject.getString("name"));
        goods.setNum(jsonObject.getInteger("num"));
        goods.setInformation(jsonObject.getString("information"));
        goods.setState(jsonObject.getString("state"));
        return goods;
    }
}
