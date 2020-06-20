package org.shancm.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.shancm.common.enums.ErrorCodeEnum;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseException extends Exception {

    private String code;
    private String msg;

    ResponseException (ErrorCodeEnum errorCodeEnum){
        this.code = errorCodeEnum.getErrorCode();
        this.msg = errorCodeEnum.getErrorMsg();
    }

}
