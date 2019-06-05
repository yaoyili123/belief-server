package com.yaoyili.service.impl;

import com.yaoyili.service.MainService;
import com.yaoyili.utils.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;
import sun.plugin.com.Utils;

import javax.rmi.CORBA.Util;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class MainServiceImpl implements MainService {

    @Override
    public void savePicture(MultipartFile picture) {

        try {
            //服务器当前部署目录
            String curPath = ClassUtils.getDefaultClassLoader().getResource("").getPath()
                    + "static/" + picture.getOriginalFilename();

            //真正目录
            String path = System.getProperty("user.dir") + "/src/main/resources/static/"
                    + picture.getOriginalFilename();

            FileUtils.saveFile(curPath, picture.getBytes());
            FileUtils.saveFile(path, picture.getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
