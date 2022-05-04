package com.rest;
public class Rest {
    private String uName;
    private int uId;

    public Rest(String uName, int uId){
        this.uName = uName;
        this.uId = uId;

    }
    /*public Rest(int uId, String func){
        this.uId = uId;
        this.func = func;
    }*/

    public Rest(int uId){
        this.uId = uId;
    }
    public Rest(String uName){
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
