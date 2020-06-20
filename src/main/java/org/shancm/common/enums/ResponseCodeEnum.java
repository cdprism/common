package org.shancm.common.enums;


public enum  ResponseCodeEnum {

    SUCCESS("0000", "success");

    ResponseCodeEnum(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    private String code;
    private String msg;

    public String getResMsg() {
        return msg;
    }

    public String getResCode() {
        return code;
    }
}
