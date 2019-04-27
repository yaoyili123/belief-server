package com.yaoyili.service;

import com.yaoyili.model.UserJoinClass;

import java.util.List;

public interface SportService {

    List<UserJoinClass> getJoinedClasses(int uid);

    int getTotalTime(int uid);
}
