package com.seeu.filesystem.service;

import org.springframework.boot.context.properties.ConfigurationProperties;

//@Component
@ConfigurationProperties(prefix = "seeu.storage")
//@ConfigurationProperties("storage")
public class StorageProperties {

    /**
     * Folder location for storing files
     */
//    private String location = "templates/upload-dir";

    private String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
