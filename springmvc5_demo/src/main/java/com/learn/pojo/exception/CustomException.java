package com.learn.pojo.exception;

public class CustomException extends Exception{

    private String messsage;

    public String getMesssage() {
        return messsage;
    }

    public void setMesssage(String messsage) {
        this.messsage = messsage;
    }

    public CustomException(String message){
        super(message);
        this.messsage = message;
    }
}
