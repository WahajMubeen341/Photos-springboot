package com.spring.project.g.photo.clone.Modal;

public class Photo {

    //empty constructor
    public Photo(){}

    public Photo(String id, String fileName) {
        this.id = id;
        this.fileName = fileName;
    }

    private String id;
    private String fileName;

    public String getId() {
        return id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
