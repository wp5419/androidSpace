package com.app.model;

import java.io.Serializable;

/**
 * Created by wafer on 2016/9/23.
 */

public class FileInfo implements Serializable {

    private String upLoader;
    private String id;
    private String uploadDate;
    private String fileName;
    private String size;
    private String fileUrl;
    private String fielId;

    public String getUpLoader() {
        return upLoader;
    }

    public void setUpLoader(String upLoader) {
        this.upLoader = upLoader;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getFielId() {
        return fielId;
    }

    public void setFielId(String fielId) {
        this.fielId = fielId;
    }

    public String getFileRealUrl() {
        return fileRealUrl;
    }

    public void setFileRealUrl(String fileRealUrl) {
        this.fileRealUrl = fileRealUrl;
    }

    private String fileRealUrl;





}
