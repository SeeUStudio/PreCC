package com.seeu.filesystem.service;

import com.TurnBackUtil;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.MultipartFilter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * Created by neo on 14/01/2017.
 */
@Service
public class FileUploadService {

    private static final Logger logger = LogManager.getLogger(FileUploadService.class);

    private final Path mypath;

    public FileUploadService(StorageProperties properties) {
        this.mypath = Paths.get(properties.getLocation());
    }


//    private final Path rootLocation;

    @Bean(name = "multipartResolver")
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(41024000);// 10MB
        logger.info(">> multipartResolver was used. ( FileUploadService.class )");
        return multipartResolver;
    }

    @Bean
    @Order(0)
    public MultipartFilter multipartFilter() {
        logger.info(">> multipartFilter was used. ( FileUploadService.class )");
        return new MultipartFilter();
    }

//    @Autowired
//    public FileUploadService(StorageProperties properties) {
//        this.rootLocation = Paths.get(properties.getLocation());
//    }


    @Autowired
    TurnBackUtil turnBackUtil;


    /**
     * @param file
     * @param filesuffix like .png (add dot necessary)
     * @param path       relation path, no need to add '/' prefix
     * @return if success return filename, else return null. No path added.
     */
    public String upload(MultipartFile file, String filesuffix, Path path) {

        // create filepath if necessary
//        String pathname = rootLocation + "/" + path + "/";
        Path pathname = mypath.resolve(path);
        File f = pathname.toFile();
        if (!f.exists()) {
            f.mkdirs();
        }

        try {
            String uuid = UUID.randomUUID().toString();
            String name = uuid + filesuffix;
            File fn = new File(pathname + "/" + name);
            FileUtils.writeByteArrayToFile(fn, file.getBytes());
            return name;
        } catch (IOException exception) {
            logger.error("文件上传 IOException 异常" + exception);
        } catch (Exception e) {
            logger.error("文件上传 Exception 异常" + e);
        }
        return null;
    }

}
