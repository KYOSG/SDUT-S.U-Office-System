package com.sdut.dto;

import lombok.Data;

/**
 * @Projectname: Cloud
 * @Filename: GetUserDto
 * @Author: SpringForest
 * @Data:2022/11/13 12:10
 * @Description:
 */
@Data
public class GetUserRequest {
    private String id;
    private String name;
    private int pageSize;
    private int pageNum;
}
