package com.tencentcloudapi.Util;


public class TenResult extends BaseResult {
    public TenResult(){
        super();
    }
    public TenResult(EnumCmpResult tenResult, Object data){
        super(tenResult.getCode(),tenResult.getMessage(),data);
    }
    public TenResult(int code, String message, Object data){
        super(code,message,data);
    }
}
