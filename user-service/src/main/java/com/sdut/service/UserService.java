package com.sdut.service;

import com.sdut.dto.GetUserRequest;
import com.sdut.entity.User;
import com.sdut.utils.ResV;

/**
 * @Projectname: Cloud
 * @Filename: UserService
 * @Author: SpringForest
 * @Data:2022/11/12 21:32
 * @Description:
 */

public interface UserService {

    public ResV checkLogin(String id, String pwd);

    public ResV getUser(GetUserRequest getUserRequest);

    public ResV removeUser(int id);

    public ResV update(User user);

    public ResV add(User user);
}
