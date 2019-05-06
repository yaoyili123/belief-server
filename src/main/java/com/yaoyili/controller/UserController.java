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

    @PostMapping(value = "login")
    public ResponseWrapper login(@RequestBody UserAuth userAuth) {
        int res = userService.login(userAuth);
        ResponseWrapper responseWrapper = null;
        switch (res) {
            case 0: {
                responseWrapper = new ResponseWrapper<Object>(0, "登陆成功", null);
                break;
            }
            case 1: {
                responseWrapper = new ResponseWrapper<Object>(1, "用户名不存在", null);
                break;
            }
            case 2: {
                responseWrapper = new ResponseWrapper<Object>(2, "密码错误", null);
                break;
            }
        }
        return responseWrapper;
    }

    @GetMapping(value = "sport_info/{uid}")
    public UserSportInfo getSportInfo(@PathVariable(value = "uid") Integer uid) {
        return userService.getSportInfo(uid);
    }

    @PutMapping(value = "user_info")
    public String updateUserInfo(@RequestBody UserInfo userInfo) {
        userService.updateUserInfo(userInfo);
        return "success";
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
