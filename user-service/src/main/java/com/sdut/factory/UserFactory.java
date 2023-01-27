package com.sdut.factory;

import com.alibaba.fastjson.JSONObject;
import com.sdut.entity.User;

/**
 * @Projectname: Cloud
 * @Filename: UserFactory
 * @Author: SpringForest
 * @Data:2022/11/13 09:16
 * @Description:
 */

public class UserFactory {
    public static User getUser(JSONObject jsonObject) {
        User user = new User();
        user.setId(jsonObject.getString("id"));
        user.setAvatar(jsonObject.getString("avatar"));
        user.setName(jsonObject.getString("name"));
        user.setPassword(jsonObject.getString("password"));
        user.setDepartment(jsonObject.getString("department"));
        user.setIdentity(jsonObject.getString("identity"));
        user.setPhone(jsonObject.getString("phone"));
        return user;
    }
}
