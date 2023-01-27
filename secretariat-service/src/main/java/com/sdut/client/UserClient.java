package com.sdut.client;

import com.alibaba.fastjson.JSONObject;
import com.sdut.utils.ResV;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Projectname: Cloud
 * @Filename: UserClient
 * @Author: SpringForest
 * @Data:2022/11/8 18:27
 * @Description: 使用openFeign替代RestTemplate，使用方法类似Mybatis
 * 在此处声明完毕后在需要调用的地方直接注入使用即可
 */
@FeignClient("user-service")//声明user-service服务为HTTP请求客户端
public interface UserClient {
    @RequestMapping("/user/getUser")
    public ResV getUser(JSONObject jsonObject);
}
