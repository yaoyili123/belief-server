package com.yaoyili.dao;

import com.yaoyili.model.ShareDetail;

public interface ShareDetailMapper {
    int deleteByPrimaryKey(Integer sid);

    int insert(ShareDetail record);

    int insertSelective(ShareDetail record);

    ShareDetail selectByPrimaryKey(Integer sid);

    int updateByPrimaryKeySelective(ShareDetail record);

    int updateByPrimaryKeyWithBLOBs(ShareDetail record);
}