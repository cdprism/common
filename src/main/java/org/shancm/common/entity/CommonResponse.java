package org.shancm.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.shancm.common.enums.ErrorCodeEnum;
import org.shancm.common.enums.ResponseCodeEnum;
import org.shancm.common.exception.ResponseException;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse<T> implements Serializable {

    private String resCode;
    private String resMsg;
    private T data;

    /**
     *成功响应
     */
    public static <T> CommonResponse<T> success(){
        CommonResponse<T> response = new CommonResponse<>();
        response.setResCode(ResponseCodeEnum.SUCCESS.getResCode());
        response.setResMsg(ResponseCodeEnum.SUCCESS.getResMsg());
        return response;
    }

    /**
     * 成功响应，并返回数据
     *
     * @param data 附带数据
     */
    public static <T> CommonResponse<T> success(T data){
        CommonResponse<T> response = CommonResponse.success();
        response.setData(data);
        return response;
    }

    /**
     * 响应失败
     */
    public static <T> CommonResponse<T> error(){
        CommonResponse<T> response = new CommonResponse<>();
        response.setResCode(ErrorCodeEnum.FAILURE.getErrorCode());
        response.setResMsg(ErrorCodeEnum.FAILURE.getErrorMsg());
        return response;
    }

    /**
     * 响应失败
     *
     * @param code code
     * @param msg msg
     */
    public static <T> CommonResponse<T> error(String code, String msg){
        CommonResponse<T> response = new CommonResponse<>();
        response.setResCode(code);
        response.setResMsg(msg);
        return response;
    }

    /**
     * 响应失败, 并返回错误信息
     *
     * @param code code
     * @param msg msg
     * @param e 异常
     */
    public static CommonResponse<String> error(String code, String msg, Exception e){
        CommonResponse<String> response = CommonResponse.error(code, msg);
        response.setData(e.getMessage());
        return response;
    }

    /**
     * 响应失败,返回封装错误信息
     * @param e 封装错误信息 {@link ErrorCodeEnum}
     */
    public static <T> CommonResponse<T> error(ErrorCodeEnum e){
        return CommonResponse.error(e.getErrorCode(), e.getErrorMsg());
    }

    /**
     * 响应失败,返回异常信息
     * @param e 封装异常 {@link ResponseException}
     */
    public static CommonResponse<String> error(ResponseException e){
        CommonResponse<String> response = CommonResponse.error(e.getCode(), e.getMsg());
        response.setData(e.getMessage());
        return response;
    }

}
