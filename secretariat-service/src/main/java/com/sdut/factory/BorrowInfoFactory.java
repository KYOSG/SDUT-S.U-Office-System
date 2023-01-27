package com.sdut.factory;

import com.alibaba.fastjson.JSONObject;
import com.sdut.entity.BorrowInfo;

/**
 * @Projectname: Cloud
 * @Filename: BorrowInfoFactory
 * @Author: SpringForest
 * @Data:2022/11/13 11:47
 * @Description:
 */

public class BorrowInfoFactory {
    public static BorrowInfo getBorrowInfo(JSONObject jsonObject) {
        BorrowInfo borrowInfo = new BorrowInfo();
        borrowInfo.setId(jsonObject.getInteger("id"));
        borrowInfo.setUserId(jsonObject.getString("userId"));
        borrowInfo.setBorrowDate(jsonObject.getString("borrowDate"));
        borrowInfo.setReturnDate(jsonObject.getString("returnDate"));
        borrowInfo.setInformation(jsonObject.getString("information"));
        borrowInfo.setState(jsonObject.getString("state"));
        return borrowInfo;
    }
}
