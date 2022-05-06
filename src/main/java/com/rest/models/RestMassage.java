package com.rest.models;

public class RestMassage {
    private String massage;

    public RestMassage(){}
    public RestMassage(String massage){
        this.massage = massage;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}
