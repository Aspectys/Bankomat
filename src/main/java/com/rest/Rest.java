package com.rest;
public class Rest {
    private final String acctype;
    private final String contstr;
    public Rest(String acctype, String contstr){
        this.contstr = contstr;
        this.acctype = acctype;
    }
    public String getAcctype(){
        return acctype;
    }
    public String getContstr(){
        return contstr;
    }
}
