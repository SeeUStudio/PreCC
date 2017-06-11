package com.seeu.filesystem.controller;


import com.seeu.filesystem.service.FileDownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by neo on 19/01/2017.
 */
@RestController
@RequestMapping("/download")
public class FileDownloadController {
    @Autowired
    FileDownloadService fileDownloadService;

    /**
     * @param filename
     * @param dir
     * @return
     */
    @RequestMapping("/{dir}/{filename:.+}")
    public Object loadFile(@PathVariable(value = "filename") String filename, @PathVariable(value = "dir") String dir) {
        return fileDownloadService.loadFile(dir, filename);
    }
}
