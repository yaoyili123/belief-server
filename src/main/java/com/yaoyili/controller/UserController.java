package com.yaoyili.controller;

import com.yaoyili.model.*;
import com.yaoyili.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping(value = "register")
    public ResponseWrapper register(@RequestBody UserAuth userAuth) {
        int res = userService.register(userAuth);
        ResponseWrapper responseWrapper = null;
        switch (res) {
            case 0: {
                responseWrapper = new ResponseWrapper<Object>(0, "注册成功", null);
                break;
            }
            case 1: {
                responseWrapper = new ResponseWrapper<Object>(1, "用户名已存在", null);
            }
        }
        return responseWrapper;
    }

    @GetMapping(value = "sport_info/{uid}")
    public UserSportInfo getSportInfo(@PathVariable(value = "uid") Integer uid) {
        return userService.getSportInfo(uid);
    }

    @PutMapping(value = "user_info")
    public void updateUserInfo(@RequestBody UserInfo userInfo) {
        userService.updateUserInfo(userInfo);
    }

    @GetMapping(value = "user_info/{uid}")
    public UserInfo getUserInfo(@PathVariable(value = "uid") Integer uid) {
        return userService.getUserInfo(uid);
    }

    @GetMapping(value = "kcal_trend/{uid}/{type}")
    public List<UserKcalTrend> getKcalTrand(@PathVariable(value = "uid")int uid, @PathVariable(value = "type")int type) {
        return userService.getKcalTrand(uid, type);
    }
}
