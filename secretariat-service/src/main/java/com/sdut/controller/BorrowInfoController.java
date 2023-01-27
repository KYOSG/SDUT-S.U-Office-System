package com.sdut.controller;

import com.alibaba.fastjson.JSONObject;
import com.sdut.entity.BorrowInfo;
import com.sdut.factory.BorrowInfoFactory;
import com.sdut.service.BorrowInfoService;
import com.sdut.utils.ResV;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Projectname: Cloud
 * @Filename: BorrowInfoController
 * @Author: SpringForest
 * @Data:2022/11/13 11:43
 * @Description:
 */
@RestController
@RequestMapping("/borrowInfo")
public class BorrowInfoController {
    @Resource
    private BorrowInfoService borrowInfoService;

    @GetMapping("/getBorrowInfoByUserId")
    @ResponseBody
    public ResV getGoodsByName(@RequestParam String userId, int pageSize, int pageNum) {
        return borrowInfoService.getBorrowInfoByUserId(userId, pageSize, pageNum);
    }

    @PostMapping("/add")
    @ResponseBody
    public ResV add(@RequestBody JSONObject jsonObject) {
        BorrowInfo borrowInfo = BorrowInfoFactory.getBorrowInfo(jsonObject);
        return borrowInfoService.add(borrowInfo);
    }

    @PostMapping("/update")
    @ResponseBody
    public ResV update(@RequestBody JSONObject jsonObject) {
        BorrowInfo borrowInfo = BorrowInfoFactory.getBorrowInfo(jsonObject);
        return borrowInfoService.update(borrowInfo);
    }

    @DeleteMapping("/remove")
    @ResponseBody
    public ResV remove(@RequestParam int id) {
        return borrowInfoService.remove(id);
    }
}
