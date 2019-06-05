package com.yaoyili.controller;

import com.yaoyili.model.ShareInfo;
import com.yaoyili.service.CommService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping(value = "share_detail/{sid}")
    public ResponseWrapper getShareDetail(@PathVariable(value = "sid") int sid) {
        return new ResponseWrapper<ShareInfoResponse>(
                200, "SUCCESS",
                commService.getShareDetail(sid));
    }

    @PostMapping(value = "share")
    public ResponseWrapper publishShare(@RequestBody RequestShare share) {

        commService.publishShare(share);
        return new ResponseWrapper<Object>(
                200, "SUCCESS",
                new HashMap<>());
    }
}
