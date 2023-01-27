package com.sdut.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sdut.entity.BorrowInfo;
import com.sdut.utils.ResV;

/**
 * @author springforest
 * @description 针对表【borrowInfo(借用登记表)】的数据库操作Service
 * @createDate 2022-11-13 11:41:50
 */

public interface BorrowInfoService extends IService<BorrowInfo> {
    public ResV getBorrowInfoByUserId(String userId, int pageSize, int pageNum);

    public ResV add(BorrowInfo borrowInfo);

    public ResV remove(int id);

    public ResV update(BorrowInfo borrowInfo);
}
