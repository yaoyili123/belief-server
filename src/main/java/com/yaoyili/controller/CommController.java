package com.yaoyili.controller;

import com.yaoyili.model.*;
import com.yaoyili.service.CommService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
//@ResponseStatus(HttpStatus.OK)
@RequestMapping(value = "comm")
public class CommController {

    @Autowired
    private CommService commService;

    @GetMapping(value = "share_list")
    public ResponseWrapper getShareList() {

        return new ResponseWrapper<List>(
                200, "SUCCESS",
                commService.getShareList());
    }

    @PostMapping(value = "share")
    public ResponseWrapper publishShare(@RequestBody RequestShare share) {

        commService.publishShare(share);
        return new ResponseWrapper<Object>(
                200, "SUCCESS",
                new HashMap<>());
    }
}
