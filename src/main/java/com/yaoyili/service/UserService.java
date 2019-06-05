package com.yaoyili.service;

import com.yaoyili.model.UserAuth;
import com.yaoyili.model.UserInfo;
import com.yaoyili.model.UserKcalTrend;
import com.yaoyili.model.UserSportInfo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface UserService {

    int register(UserAuth userAuth);

    Map login(UserAuth userAuth);

    UserSportInfo getSportInfo(int uid);

    UserInfo getUserInfo(int uid);

    void updateUserInfo(UserInfo userInfo);

    List<UserKcalTrend> getKcalTrand(int uid, int type);

}
