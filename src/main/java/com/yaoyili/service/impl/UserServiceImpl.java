package com.yaoyili.service.impl;

import com.yaoyili.dao.UserAuthMapper;
import com.yaoyili.dao.UserInfoMapper;
import com.yaoyili.dao.UserSportInfoMapper;
import com.yaoyili.model.UserAuth;
import com.yaoyili.model.UserInfo;
import com.yaoyili.model.UserSportInfo;
import com.yaoyili.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserAuthMapper userAuthMapper;

    @Autowired
    private UserSportInfoMapper userSportInfoMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public int register(UserAuth userAuth) {
        if (userAuthMapper.isRepeated(userAuth.getUsername()) != null)
            return 1;
        userAuthMapper.insertSelective(userAuth);
        UserAuth curUser = userAuthMapper.isRepeated(userAuth.getUsername());
        //创建相应的user_sport_info字段和user_info字段
        userSportInfoMapper.insertSelective(new UserSportInfo(curUser.getUid(), 0, 0, 0));
        userInfoMapper.insertSelective(new UserInfo(curUser.getUid(), curUser.getUsername(),
                null, null, null));
        return 0;
    }
}
