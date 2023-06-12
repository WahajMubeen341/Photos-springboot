package com.spring.project.g.photo.clone.Modal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class Photo {



    private String id;

    @NotEmpty
    private String fileName;

    @JsonIgnore
    private byte[] data;

    private String contentType;





    //empty constructor
    public Photo(){}

    public Photo(String id, String fileName) {
        this.id = id;
        this.fileName = fileName;
    }


    public byte[] getData() {
        return data;
    }

    public String getId() {
        return id;
    }

    public String getFileName() {
        return fileName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


    public void setData(byte[] data) {
        this.data = data;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}

