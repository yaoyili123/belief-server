package com.yaoyili.service.impl;

import com.yaoyili.dao.SportClassMapper;
import com.yaoyili.dao.UserJoinClassMapper;
import com.yaoyili.dao.UserKcalTrendMapper;
import com.yaoyili.dao.UserSportInfoMapper;
import com.yaoyili.model.SportClass;
import com.yaoyili.model.UserJoinClass;
import com.yaoyili.model.UserKcalTrend;
import com.yaoyili.model.UserSportInfo;
import com.yaoyili.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.reducing;

@Service
public class SportServiceImpl implements SportService {

    @Autowired
    private UserJoinClassMapper userJoinClassMapper;

    @Autowired
    private UserKcalTrendMapper userKcalTrendMapper;

    @Autowired
    private UserSportInfoMapper userSportInfoMapper;

    @Autowired
    private SportClassMapper sportClassMapper;

    @Override
    public SportClass getSportClass(int scid) {
        return sportClassMapper.selectByPrimaryKey(scid);
    }

    @Override
    public List<SportClass> getJoinedClasses(int uid) {

        List<Integer> classList = userJoinClassMapper.getClassesbyUser(uid);
        List<SportClass> res = new ArrayList<SportClass>();
        for (Integer scid: classList) {
            res.add(sportClassMapper.selectByPrimaryKey(scid));
        }
        return res;
    }

    @Override
    public int getTotalKcal(int uid) {
        List<UserKcalTrend> trands = userKcalTrendMapper.selectbyUser(uid);
        return trands.stream().collect(reducing(0, UserKcalTrend::getKcal,(a, b) -> a + b));
    }

    @Override
    public void addClassToUser(int uid, List<Integer> classList) {
        List ds = new ArrayList<UserJoinClass>();
        for (Integer item: classList) {
            ds.add(new UserJoinClass(uid, item));
        }
        ds.stream().forEach((item) -> userJoinClassMapper.insert((UserJoinClass)item));
    }

    @Override
    public void settleKcal(int uid, int kcal, int time) {
        //确认user_kcal_trend今日的是否添加
        UserKcalTrend kcalTrend = userKcalTrendMapper
                .selectbyKeys(
                        new UserKcalTrend(uid, null, new Date(System.currentTimeMillis())));
        if (kcalTrend == null) {
            userKcalTrendMapper.insert(new UserKcalTrend(uid, kcal, new Date(System.currentTimeMillis())));
            kcalTrend = userKcalTrendMapper
                    .selectbyKeys(
                            new UserKcalTrend(uid, null, new Date(System.currentTimeMillis())));
        }
        //修改user_kcal_trend以及user_sport_info
        userKcalTrendMapper.updateByPrimaryKeySelective(new UserKcalTrend(uid, kcalTrend.getKcal() + kcal, new Date(System.currentTimeMillis())));
        UserSportInfo sportInfo =  userSportInfoMapper.selectByPrimaryKey(uid);
        userSportInfoMapper.updateByPrimaryKeySelective(new UserSportInfo(
                uid, sportInfo.getTotalSportTime() + time,
                sportInfo.getTotalKcal() + kcal,
                kcalTrend.getKcal() + kcal));
    }
}
