package com.yaoyili.dao;

import com.yaoyili.model.ShareInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShareInfoMapper {
    int deleteByPrimaryKey(Integer sid);

    int insert(ShareInfo record);

    int insertSelective(ShareInfo record);

    ShareInfo selectByPrimaryKey(Integer sid);

    int updateByPrimaryKeySelective(ShareInfo record);

    int updateByPrimaryKey(ShareInfo record);
}