package com.sdut.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sdut.dto.GetUserRequest;
import com.sdut.entity.User;
import com.sdut.mapper.UserMapper;
import com.sdut.service.UserService;
import com.sdut.utils.PageFactory;
import com.sdut.utils.ResV;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Projectname: Cloud
 * @Filename: UserServiceImpl
 * @Author: SpringForest
 * @Data:2022/11/12 21:32
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public ResV checkLogin(String id, String pwd) {
        //查询用户信息
        User user = userMapper.selectById(id);
        //判断
        if (user == null) {
            //用户名不存在
            return ResV.error("用户名不存在，请联系管理员注册");
        } else {
            //todo:对密码加密

            //使用加密后的密码与user中的密码进行匹配
            if (user.getPassword().equals(pwd)) {
                //验证成功
                //String token = Base64Utils.encode(userId);
                Map<String, Object> map = new HashMap<>();
                map.put("user", user);
                return ResV.ok(map);
            } else {
                //验证失败
                return ResV.error("密码错误");
            }
        }
    }

    @Override
    public ResV getUser(GetUserRequest getUserRequest) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        Page<User> page = new Page<>(getUserRequest.getPageNum(), getUserRequest.getPageSize());
        if (getUserRequest.getName() != null && getUserRequest.getName() != "") {
            queryWrapper.eq("name", getUserRequest.getName());
            User user = userMapper.selectOne(queryWrapper);
            List<User> list = new ArrayList<>();
            list.add(user);
            Map<String, Object> map = new HashMap<>();
            map.put("list", list);
            return ResV.ok(map);
        } else if (getUserRequest.getId() != null && getUserRequest.getId() != "") {
            queryWrapper.eq("id", getUserRequest.getId());
            User user = userMapper.selectOne(queryWrapper);
            List<User> list = new ArrayList<>();
            list.add(user);
            Map<String, Object> map = new HashMap<>();
            map.put("list", list);
            return ResV.ok(map);
        } else {
            userMapper.selectPage(page, null);
            return ResV.ok(PageFactory.getPageInfo(page));
        }

    }

    @Override
    public ResV removeUser(int id) {
        try {
            userMapper.deleteById(id);
        } catch (Exception e) {
            System.out.println(e);
            return ResV.error(e.toString());
        }
        return ResV.ok();
    }

    @Override
    public ResV update(User user) {
        try {
            userMapper.updateById(user);
        } catch (Exception e) {
            System.out.println(e);
            return ResV.error(e.toString());
        }
        return ResV.ok();
    }

    @Override
    public ResV add(User user) {
        try {
            userMapper.insert(user);
        } catch (Exception e) {
            System.out.println(e);
            return ResV.error(e.toString());
        }
        return ResV.ok();
    }
}
