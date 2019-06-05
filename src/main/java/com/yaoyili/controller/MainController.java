package com.yaoyili.controller;

import com.yaoyili.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MainController {

    @Autowired
    private MainService mainService;

    @PostMapping(value = "uploadFile")
    public ResponseWrapper uploadFile(@RequestParam(value = "file") MultipartFile pic) {

        mainService.savePicture(pic);
        return new ResponseWrapper<Map>(
                200, "SUCCESS",
                new HashMap());
    }
}
