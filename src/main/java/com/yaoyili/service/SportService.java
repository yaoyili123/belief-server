package com.yaoyili.service;

import com.yaoyili.model.SportClass;
import com.yaoyili.model.UserJoinClass;

import java.util.List;

public interface SportService {

    SportClass getSportClass(int scid);

    List<SportClass> getJoinedClasses(int uid);

    int getTotalKcal(int uid);

    void addClassToUser(int uid, List<Integer> classList);

    void settleKcal(int uid, int kcal, int time);
}
