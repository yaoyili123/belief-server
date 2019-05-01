package com.yaoyili.controller;

import com.yaoyili.model.RequestShare;
import com.yaoyili.model.ShareDetail;
import com.yaoyili.model.ShareInfo;
import com.yaoyili.service.CommService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "comm")
public class CommController {

    @Autowired
    private CommService commService;

    @GetMapping(value = "share_list")
    public List<ShareInfo> getShareList() {
        return commService.getShareList();
    }

    @PostMapping(value = "share")
    public void publishShare(@RequestBody RequestShare share) {
        commService.publishShare(share);
    }
}
