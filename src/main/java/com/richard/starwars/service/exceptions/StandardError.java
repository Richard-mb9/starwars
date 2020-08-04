package com.richard.starwars.service.exceptions;

import java.io.Serializable;

public class StandardError implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Long rimestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

    public StandardError(){

    }

    public StandardError(Long rimestamp, Integer status, String error, String message, String path) {
        this.rimestamp = rimestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public Long getRimestamp() {
        return rimestamp;
    }

    public void setRimestamp(Long rimestamp) {
        this.rimestamp = rimestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    

}