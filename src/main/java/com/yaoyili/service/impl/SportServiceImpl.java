package com.yaoyili.service.impl;

import com.yaoyili.dao.UserJoinClassMapper;
import com.yaoyili.model.UserJoinClass;
import com.yaoyili.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SportServiceImpl implements SportService {

    @Autowired
    private UserJoinClassMapper userJoinClassMapper;

    @Override
    public List<UserJoinClass> getJoinedClasses(int uid) {

        List<UserJoinClass> res =  userJoinClassMapper.getClassesbyUser(uid);
        return res != null ? res : new ArrayList<UserJoinClass>();
    }

    @Override
    public int getTotalTime(int uid) {
        return 0;
    }
}
