package com.example.childrenschool.model;

public class Upload {
    private String fileName;
    private String imageUrl;

    public Upload (){}

    public Upload(String fileName, String imageUrl){
        if (fileName.trim().equals("")){
            fileName = "no file name";
        }
        this.fileName = fileName;
        this.imageUrl = imageUrl;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
