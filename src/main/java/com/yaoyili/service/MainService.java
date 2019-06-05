package com.yaoyili.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface MainService {

    void savePicture(MultipartFile picture);
}
