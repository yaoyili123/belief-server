package com.yaoyili.dao;

import com.yaoyili.model.ShareInfo;

public interface ShareInfoMapper {
    int deleteByPrimaryKey(Integer sid);

    int insert(ShareInfo record);

    int insertSelective(ShareInfo record);

    ShareInfo selectByPrimaryKey(Integer sid);

    int updateByPrimaryKeySelective(ShareInfo record);

    int updateByPrimaryKey(ShareInfo record);
}