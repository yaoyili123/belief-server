package com.yaoyili.service.impl;

import com.yaoyili.dao.UserAuthMapper;
import com.yaoyili.dao.UserInfoMapper;
import com.yaoyili.dao.UserKcalTrendMapper;
import com.yaoyili.dao.UserSportInfoMapper;
import com.yaoyili.model.UserAuth;
import com.yaoyili.model.UserInfo;
import com.yaoyili.model.UserKcalTrend;
import com.yaoyili.model.UserSportInfo;
import com.yaoyili.service.UserService;
import com.yaoyili.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserAuthMapper userAuthMapper;

    @Autowired
    private UserSportInfoMapper userSportInfoMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private UserKcalTrendMapper userKcalTrendMapper;

    @Override
    public int register(UserAuth userAuth) {
        if (userAuthMapper.isRepeated(userAuth.getUsername()) != null)
            return -1;
        userAuthMapper.insertSelective(userAuth);
//        UserAuth curUser = userAuthMapper.isRepeated(userAuth.getUsername());
        //创建相应的user_sport_info字段和user_info字段
        userSportInfoMapper.insertSelective(new UserSportInfo(userAuth.getUid(), 0, 0, 0));
        userInfoMapper.insertSelective(new UserInfo(userAuth.getUid(), userAuth.getUsername(),
                null, null, null));
        return userAuth.getUid();
    }

    @Override
    public int login(UserAuth userAuth) {
        if (userAuthMapper.isRepeated(userAuth.getUsername()) == null)
            return -1;
        UserAuth curUser = userAuthMapper.authUser(userAuth);
        if (curUser == null)
            return -2;
        return curUser.getUid();
    }

    @Override
    public UserSportInfo getSportInfo(int uid) {
        return userSportInfoMapper.selectByPrimaryKey(uid);
    }

    @Override
    public UserInfo getUserInfo(int uid) {
        return userInfoMapper.selectByPrimaryKey(uid);
    }

    @Override
    public void updateUserInfo(UserInfo userInfo) {
        userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }

    @Override
    public List<UserKcalTrend> getKcalTrand(int uid, int type) {

        //FIXME: 这里必须声明类型让编译器知道，否则filter时会被认为obj类型
        List<UserKcalTrend> trends = userKcalTrendMapper.selectbyUser(uid);
        Date curDate = new Date(System.currentTimeMillis());

        //1：一周内，2：一个月，3：一年
        Date bound = new Date(TimeUtils.backDate(type, curDate));
        return trends.stream()
                .filter(item ->
                        item.getDate().compareTo(bound) != -1 && item.getDate().compareTo(curDate) != 1)
                .collect(Collectors.toList());
    }
}
