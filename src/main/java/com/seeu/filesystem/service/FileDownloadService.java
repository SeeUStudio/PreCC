package com.seeu.filesystem.service;

import com.CODE;
import com.TurnBackUtil;
import com.seeu.filesystem.service.storage.StorageFileNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by neo on 18/01/2017.
 */
@Service
public class FileDownloadService {

    @Autowired
    FileDownloadServiceHelper fileDownloadServiceHelper;
    @Autowired
    TurnBackUtil turnBackUtil;

    private final Path mypath;

    public FileDownloadService(StorageProperties properties) {
        this.mypath = Paths.get(properties.getLocation());
    }

    public Object loadFile(String UID,String filename) {
        return loadFile(mypath.resolve(UID), filename);
    }


    private Object loadFile(Path path, String filename) {
        if (checkName(filename)) {
            try {
                return fileDownloadServiceHelper.loadAsResource(path, filename);
            } catch (StorageFileNotFoundException e) {
//                LOGGER.warn("FileDn System Exception ::\t" + e.getMessage());
                return turnBackUtil.formIt(CODE.EXCEPTION, "找不到文件", null);
            }
        } else {
            return turnBackUtil.formIt(CODE.EXCEPTION, "文件名不合法", null);
        }
    }

    //    @RequestMapping(value = "check")
    private boolean checkName(String filename) {
//        LOGGER.warn(filename);
        if (filename == null || filename.trim().equals("")) {
            return false;
        }
        String pattern = "^(?!_)(?!.*?_$)[a-zA-Z0-9-._\u4e00-\u9fa5]+$";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(filename);
        return m.matches();
    }
}
