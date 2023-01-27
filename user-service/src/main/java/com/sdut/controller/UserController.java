package com.sdut.controller;


import com.alibaba.fastjson.JSONObject;
import com.sdut.dto.GetUserRequest;
import com.sdut.entity.User;
import com.sdut.factory.UserFactory;
import com.sdut.service.UserService;
import com.sdut.utils.ResV;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Projectname: Cloud
 * @Filename: UserController
 * @Author: SpringForest
 * @Data:2022/11/12 21:29
 * @Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResV login(@RequestBody JSONObject jsonParam) {
        String id = jsonParam.getString("id");
        String pwd = jsonParam.getString("password");

        return userService.checkLogin(id, pwd);
    }

    @PostMapping("/getUser")
    @ResponseBody
    public ResV getUser(@RequestBody JSONObject jsonObject) {
        GetUserRequest getUserRequest = new GetUserRequest();
        getUserRequest.setId(jsonObject.getString("id"));
        getUserRequest.setName(jsonObject.getString("name"));
        getUserRequest.setPageNum(jsonObject.getIntValue("pageNum"));
        getUserRequest.setPageSize(jsonObject.getIntValue("pageSize"));
        return userService.getUser(getUserRequest);
    }

    @PostMapping("/add")
    @ResponseBody
    public ResV add(@RequestBody JSONObject jsonObject) {

        User user = UserFactory.getUser(jsonObject);
        return userService.add(user);
    }

    @PostMapping("/update")
    @ResponseBody
    public ResV update(@RequestBody JSONObject jsonObject) {
        User user = UserFactory.getUser(jsonObject);
        return userService.update(user);
    }

    @DeleteMapping("/remove")
    @ResponseBody
    public ResV remove(@RequestParam int id) {
        return userService.removeUser(id);
    }

}
