package com.yaoyili.controller;

import com.yaoyili.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/sport")
public class SportController {

    @Autowired
    private SportService sportService;

    @GetMapping(value = "class/{uid}")
    public List<Integer> getJoinedClasses(@PathVariable("uid") Integer uid) {
        return sportService.getJoinedClasses(uid);
    }

    @GetMapping(value = "total_time/{uid}")
    public Integer getTotalKcal(@PathVariable("uid") Integer uid) {
        return sportService.getTotalKcal(uid);
    }

    @PostMapping(value = "add_class/{uid}")
    public String addClassToUser(@PathVariable("uid") Integer uid, @RequestBody List<Integer> classList) {
        sportService.addClassToUser(uid, classList);
        return "success";
    }

    @PutMapping(value = "/settle/{uid}/{kcal}/{time}")
    public String settleKcal(@PathVariable("uid") int uid, @PathVariable("kcal") int kcal,
                           @PathVariable("time") int time) {
        sportService.settleKcal(uid, kcal, time);
        return "success";
    }
}
