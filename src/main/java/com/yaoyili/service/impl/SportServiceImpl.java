package com.yaoyili.service.impl;

import com.yaoyili.dao.*;
import com.yaoyili.model.*;
import com.yaoyili.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private SportActionMapper sportActionMapper;

    @Override
    public Map getSportClass(int scid, int uid) {
        Map<String, Object> res = new HashMap<>();
        SportClass sc = sportClassMapper.selectByPrimaryKey(scid);
        res.put("data", sc);
        if (userJoinClassMapper.seleteById(new UserJoinClass(uid, scid)) == null)
            res.put("joined", false);
        else
            res.put("joined", true);

        return res;
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
    public List<SportClass> getAllClasses() {
        List<SportClass> classList = sportClassMapper.getAll();
        return classList;
    }

    @Override
    public int getTotalKcal(int uid) {
        List<UserKcalTrend> trands = userKcalTrendMapper.selectbyUser(uid);
        return trands.stream().collect(reducing(0, UserKcalTrend::getKcal,(a, b) -> a + b));
    }

    @Override
    public int deleteJoinedClass(int uid, int scid) {
        return userJoinClassMapper.deleteByPrimaryKey(new UserJoinClass(uid, scid));
    }

    @Override
    public void addClassToUser(int uid, int scid) {
        userJoinClassMapper.insert(new UserJoinClass(uid, scid));
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

    @Override
    public List<SportAction> getActionsByScid(int scid) {
        return sportActionMapper.getActionsByScid(scid);
    }
}
