package org.shancm.common.enums;

public enum ErrorCodeEnum {

    FAILURE("1000", "failure")
    ;

    private String code;
    private String msg;

    ErrorCodeEnum(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getErrorMsg() {
        return msg;
    }

    public String getErrorCode() {
        return code;
    }
}
