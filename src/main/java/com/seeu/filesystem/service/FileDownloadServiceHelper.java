package com.seeu.filesystem.service;

import com.seeu.filesystem.service.storage.StorageFileNotFoundException;
import org.apache.log4j.Logger;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by neo on 14/01/2017.
 */
@Service
public class FileDownloadServiceHelper {

    private Logger LOGGER = Logger.getLogger(FileDownloadServiceHelper.class);

    private final Path rootLocation;

    public FileDownloadServiceHelper(StorageProperties properties) {
        this.rootLocation = Paths.get(properties.getLocation());
    }

    /**
     * @param filename like: file-abc or xxx/yy.png
     * @return
     * @throws StorageFileNotFoundException
     */
    public Resource loadAsResource(Path path,String filename) throws StorageFileNotFoundException {
        try {
            Path file = path.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists()) {
                if (file.toFile().isDirectory()) {
                    throw new StorageFileNotFoundException("File is a directory : " + filename);
                }
                if (!resource.isReadable()) {
                    throw new StorageFileNotFoundException("Could not read file : " + filename);
                }
                return resource;
            } else {
                throw new StorageFileNotFoundException("File not exist : " + filename);
            }
        } catch (MalformedURLException e) {
            throw new StorageFileNotFoundException("Could not read file - MalformedURLException : " + filename);
        }
    }

//    private Path load(String filename) {
//        return rootLocation.resolve(filename);
//    }
}
