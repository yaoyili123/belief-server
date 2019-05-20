package com.yaoyili.controller;

import com.yaoyili.model.ResponseWrapper;
import com.yaoyili.model.SportClass;
import com.yaoyili.model.UserInfo;
import com.yaoyili.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
//@ResponseStatus(HttpStatus.OK)
@RequestMapping(value = "/sport")
public class SportController {

    @Autowired
    private SportService sportService;

    @GetMapping(value = "{scid}")
    public ResponseWrapper getSportClass(@PathVariable("scid") Integer scid) {
        return new ResponseWrapper<SportClass>(
                200, "SUCCESS",
                sportService.getSportClass(scid));
    }

    @GetMapping(value = "class/{uid}")
    public ResponseWrapper getJoinedClasses(@PathVariable("uid") Integer uid) {
        return new ResponseWrapper<List>(
                200, "SUCCESS",
                sportService.getJoinedClasses(uid));
    }

    @GetMapping(value = "total_time/{uid}")
    public ResponseWrapper getTotalKcal(@PathVariable("uid") Integer uid) {

        return new ResponseWrapper<Integer>(
                200, "SUCCESS",
                sportService.getTotalKcal(uid));
    }

    @PostMapping(value = "add_class/{uid}")
    public ResponseWrapper addClassToUser(@PathVariable("uid") Integer uid, @RequestBody List<Integer> classList) {
        sportService.addClassToUser(uid, classList);
        return new ResponseWrapper<Object>(
                200, "SUCCESS",
                new HashMap<>());
    }

    @PutMapping(value = "/settle/{uid}/{kcal}/{time}")
    public ResponseWrapper settleKcal(@PathVariable("uid") int uid, @PathVariable("kcal") int kcal,
                           @PathVariable("time") int time) {
        sportService.settleKcal(uid, kcal, time);
        return new ResponseWrapper<Object>(
                200, "SUCCESS",
                new HashMap<>());
    }
}
