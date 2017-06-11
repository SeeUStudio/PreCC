package com.seeu.filesystem.controller;

import com.CODE;
import com.TurnBackUtil;
import com.alibaba.fastjson.JSONObject;
import com.seeu.filesystem.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by neo on 16/01/2017.
 */
@RestController
@RequestMapping("/upload")
public class FileUploadController {

    @Autowired
    TurnBackUtil turnBackUtil;


    @Autowired
    FileUploadService fileUploadService;

    @PostMapping("/")
    public String upload(@RequestParam(value = "file", required = false) MultipartFile file) {
        if (file == null || file.isEmpty()) {
            return turnBackUtil.formIt(CODE.FAILURE, "上传失败，文件为空", null);
        }

        String dir = "precc";
        String type = "png";
        // handle path
        Path path = Paths.get(dir + "".toString());

        // handle type (.png)
        if (type == null)
            type = "";
        if (!type.contains(".")) {
            type = '.' + type;
        }

        String filename = fileUploadService.upload(file, type, path);
        if (filename == null) {
            return turnBackUtil.formIt(CODE.FAILURE, "上传失败", null);
        } else {
            JSONObject jo = new JSONObject();
            jo.put("filename", "/semester/" + filename);
//            jo.put("filepath", path);
            return turnBackUtil.formIt(CODE.SUCCESS, "上传成功", jo);
        }
    }
}
