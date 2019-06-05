package com.yaoyili.controller;

import com.yaoyili.model.*;
import com.yaoyili.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
            case -1: {
//                throw new RuntimeException("用户名已存在");
                responseWrapper = new ResponseWrapper<Object>(500,
                        "用户名已存在", new HashMap<>());
                break;
            }
            default: {
                Map resMap = new HashMap<String, Object>();
                resMap.put("uid", res);
                responseWrapper = new ResponseWrapper<Object>(200,
                        "注册成功", resMap);
                break;
            }
        }
        return responseWrapper;
    }

    @PostMapping(value = "login")
    public ResponseWrapper login(@RequestBody UserAuth userAuth) {
        Map res = userService.login(userAuth);
        int ret = (Integer) res.get("res");
        ResponseWrapper responseWrapper = null;
        switch (ret) {
            case -1: {
//                throw new RuntimeException("用户名不存在");
                responseWrapper = new ResponseWrapper<Object>(500,
                        "用户名不存在", new HashMap<>());
                break;
            }
            case -2: {
//                throw new RuntimeException("密码错误");
                responseWrapper = new ResponseWrapper<Object>(500,
                        "密码错误", new HashMap<>());
                break;
            }
            default:{
                res.remove("res");
                responseWrapper = new ResponseWrapper<Object>(200,
                        "登陆成功", res);
                break;
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

    @PutMapping(value = "user_info/update")
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
