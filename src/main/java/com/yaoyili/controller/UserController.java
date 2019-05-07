package com.yaoyili.controller;

import com.yaoyili.model.*;
import com.yaoyili.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                responseWrapper = new ResponseWrapper<Object>(200,
                        "注册成功", new HashMap<>());
                break;
            }
            case 1: {
                throw new RuntimeException("用户名已存在");
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
                responseWrapper = new ResponseWrapper<Object>(0,
                        "登陆成功", new HashMap<>());
                break;
            }
            case 1: {
                throw new RuntimeException("用户名不存在");
            }
            case 2: {
                throw new RuntimeException("密码错误");
            }
        }
        return responseWrapper;
    }

    @GetMapping(value = "sport_info/{uid}")
    public ResponseWrapper getSportInfo(@PathVariable(value = "uid") Integer uid) {
        return new ResponseWrapper<UserSportInfo>(
                200, "SUCCESS",
                userService.getSportInfo(uid));
    }

    @PutMapping(value = "user_info")
    public ResponseWrapper updateUserInfo(@RequestBody UserInfo userInfo) {
        userService.updateUserInfo(userInfo);
        return new ResponseWrapper<Object>(
                200, "SUCCESS",
                new HashMap<>());
    }

    @GetMapping(value = "user_info/{uid}")
    public ResponseWrapper getUserInfo(@PathVariable(value = "uid") Integer uid) {
        return new ResponseWrapper<UserInfo>(
                200, "SUCCESS",
                userService.getUserInfo(uid));
    }

    @GetMapping(value = "kcal_trend/{uid}/{type}")
    public ResponseWrapper getKcalTrand(@PathVariable(value = "uid")int uid, @PathVariable(value = "type")int type) {
        return new ResponseWrapper<List>(
                200, "SUCCESS",
                userService.getKcalTrand(uid, type));

    }
}
