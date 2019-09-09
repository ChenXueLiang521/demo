package com.tencentcloudapi.Util;

public enum EnumCmpResult {

    FAILED(-1,"failed"),
    SUCCESS(0,"success");
    public int code;
    public String message;
    EnumCmpResult(int code, String message){
        this.code=code;
        this.message=message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
