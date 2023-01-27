package com.sdut.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.HashMap;
import java.util.Map;

/**
 * @Projectname: Cloud
 * @Filename: PageFactory
 * @Author: SpringForest
 * @Data:2022/11/12 22:09
 * @Description:
 */

public class PageFactory {
    public static Map<String,Object> getPageInfo(Page<?> page){
        Map<String,Object> map = new HashMap<>();
        map.put("list",page.getRecords());
        map.put("total",page.getTotal());
        map.put("current",page.getCurrent());

        return map;
    }
}
