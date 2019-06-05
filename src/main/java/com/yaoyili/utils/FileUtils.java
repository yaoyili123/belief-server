package com.yaoyili.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class FileUtils {
    public static void saveFile(String path, byte[] bytes) throws Exception {

        File file = new File(path);
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file));
        out.write(bytes);
        out.flush();
        out.close();
    }
}
