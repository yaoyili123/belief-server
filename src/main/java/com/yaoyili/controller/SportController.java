package com.yaoyili.controller;

import com.yaoyili.model.SportClass;
import com.yaoyili.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//@ResponseStatus(HttpStatus.OK)
@RequestMapping(value = "/sport")
public class SportController {

    @Autowired
    private SportService sportService;

    @GetMapping(value = "show_class")
    public ResponseWrapper getAllClasses() {
        return new ResponseWrapper<List<SportClass>>(
                200, "SUCCESS",
                sportService.getAllClasses());
    }

    @GetMapping(value = "show_class/{scid}/{uid}")
    public ResponseWrapper getSportClass(@PathVariable("scid") Integer scid, @PathVariable("uid") Integer uid) {
        return new ResponseWrapper<Map>(
                200, "SUCCESS",
                sportService.getSportClass(scid, uid));
    }

    @GetMapping(value = "joined_class/{uid}")
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

    @PutMapping(value = "add_class/{uid}/{scid}")
    public ResponseWrapper addClassToUser(@PathVariable("uid") Integer uid, @PathVariable("scid") Integer scid) {
        sportService.addClassToUser(uid, scid);
        return new ResponseWrapper<Object>(
                200, "SUCCESS",
                new HashMap<>());
    }

    @DeleteMapping(value = "del_class/{uid}/{scid}")
    public ResponseWrapper deleteJoinedClass(@PathVariable("uid") Integer uid, @PathVariable("scid") Integer scid) {
        if (sportService.deleteJoinedClass(uid, scid) <= 0) {
            return new ResponseWrapper<Object>(
                    500, "删除失败",
                    new HashMap<>());
        }
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

    @GetMapping(value = "/actions/{scid}")
    public ResponseWrapper getActionsByScid(@PathVariable("scid") int scid) {
        return new ResponseWrapper<List>(
                200, "SUCCESS",
                sportService.getActionsByScid(scid));
    }
}
