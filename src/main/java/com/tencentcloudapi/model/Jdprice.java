package com.tencentcloudapi.model;

import java.io.Serializable;

public class Jdprice implements Serializable{
    private  int id;
    private  int skuid;
    private  int ischange;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSkuid() {
        return skuid;
    }

    public void setSkuid(int skuid) {
        this.skuid = skuid;
    }

    public int getIschange() {
        return ischange;
    }

    public void setIschange(int ischange) {
        this.ischange = ischange;
    }
}
