package com.rest.models;
public class RestUser {
    private String uName;
    private int uId;

    public RestUser(String uName, int uId){
        this.uName = uName;
        this.uId = uId;

    }
    public RestUser(){}
    public RestUser(int uId){
        this.uId = uId;
    }
    public RestUser(String uName){
        this.uName = uName;
    }
    /*public Rest(int uId, String uName){
        this.uName = uName;
        this.uId = uId;
    }*/
    public int getUId(){
        return uId;
    }
    public String getUName(){
        return uName;
    }
}
