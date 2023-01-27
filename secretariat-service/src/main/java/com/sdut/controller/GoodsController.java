package com.sdut.controller;

import com.alibaba.fastjson.JSONObject;
import com.sdut.entity.Goods;
import com.sdut.factory.GoodsFactory;
import com.sdut.service.GoodsService;
import com.sdut.utils.ResV;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Projectname: Cloud
 * @Filename: GoodsController
 * @Author: SpringForest
 * @Data:2022/11/13 09:42
 * @Description: 物资Controller
 */

@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Resource
    private GoodsService goodsService;

    @GetMapping("/getGoodsByName")
    @ResponseBody
    public ResV getGoodsByName(@RequestParam String name, int pageSize, int pageNum) {
        return goodsService.getGoodsByName(name, pageSize, pageNum);
    }

    @PostMapping("/add")
    @ResponseBody
    public ResV add(@RequestBody JSONObject jsonObject) {
        Goods goods = GoodsFactory.getGood(jsonObject);
        return goodsService.add(goods);
    }

    @PostMapping("/update")
    @ResponseBody
    public ResV update(@RequestBody JSONObject jsonObject) {
        Goods goods = GoodsFactory.getGood(jsonObject);
        return goodsService.update(goods);
    }

    @DeleteMapping("/remove")
    @ResponseBody
    public ResV remove(@RequestParam int id) {
        return goodsService.remove(id);
    }
}
