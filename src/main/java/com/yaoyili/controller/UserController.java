package com.yaoyili.controller;

import com.yaoyili.model.ResponseWrapper;
import com.yaoyili.model.UserAuth;
import com.yaoyili.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping(value = "/register")
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

}
