package com.yaoyili.service;

import com.yaoyili.model.SportAction;
import com.yaoyili.model.SportClass;
import com.yaoyili.model.UserJoinClass;

import java.util.List;
import java.util.Map;

public interface SportService {

    List<SportClass> getAllClasses();

    Map getSportClass(int scid, int uid);

    List<SportClass> getJoinedClasses(int uid);

    int getTotalKcal(int uid);

    void addClassToUser(int uid, int scid);

    void settleKcal(int uid, int kcal, int time);

    int deleteJoinedClass(int uid, int scid);

    List<SportAction> getActionsByScid(int scid);

}
