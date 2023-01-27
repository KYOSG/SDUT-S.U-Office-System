package com.sdut.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sdut.client.UserClient;
import com.sdut.entity.BorrowInfo;
import com.sdut.mapper.BorrowInfoMapper;
import com.sdut.service.BorrowInfoService;
import com.sdut.utils.PageFactory;
import com.sdut.utils.ResV;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author springforest
 * @description 针对表【borrowInfo(借用登记表)】的数据库操作Service实现
 * @createDate 2022-11-13 11:41:50
 */
@Service
public class BorrowInfoServiceImpl extends ServiceImpl<BorrowInfoMapper, BorrowInfo>
        implements BorrowInfoService {

    @Resource
    private BorrowInfoMapper borrowInfoMapper;

    @Resource
    private UserClient userClient;

    @Override
    public ResV getBorrowInfoByUserId(String userId, int pageSize, int pageNum) {
        Page<BorrowInfo> page = new Page<>(pageNum, pageSize);

        //调用user-service接口获取用户名对应的id
        String s = "{" + "\"id\":\"" + userId + "\"" + "}";

        //通过OpenFeign跨服务调用接口获取User信息
        userClient.getUser(JSONObject.parseObject(s)).get("list");
        //将获取的ResV解包并分离元素
        String[] temp = userClient.getUser(JSONObject.parseObject(s)).get("list").toString().split(",");
        if (temp == null) {
            return ResV.ok("未查询到信息");
        }

        //获取用户ID
        int c = temp[0].indexOf("=");

        String id = temp[0].substring(c + 1);

        QueryWrapper<BorrowInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", id);

        try {
            borrowInfoMapper.selectPage(page, queryWrapper);
        } catch (Exception e) {
            System.out.println(e);
            return ResV.error(e.toString());
        }

        return ResV.ok(PageFactory.getPageInfo(page));
    }

    @Override
    public ResV add(BorrowInfo borrowInfo) {
        try {
            borrowInfoMapper.insert(borrowInfo);
        } catch (Exception e) {
            System.out.println(e);
            return ResV.error(e.toString());
        }
        return ResV.ok();
    }

    @Override
    public ResV remove(int id) {
        try {
            borrowInfoMapper.deleteById(id);
        } catch (Exception e) {
            System.out.println(e);
            return ResV.error(e.toString());
        }
        return ResV.ok();
    }

    @Override
    public ResV update(BorrowInfo borrowInfo) {
        try {
            borrowInfoMapper.updateById(borrowInfo);
        } catch (Exception e) {
            System.out.println(e);
            return ResV.error(e.toString());
        }
        return ResV.ok();
    }
}




